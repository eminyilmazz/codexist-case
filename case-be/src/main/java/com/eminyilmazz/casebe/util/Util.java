package com.eminyilmazz.casebe.util;

import com.eminyilmazz.casebe.entity.dto.PlaceDTO;
import com.eminyilmazz.casebe.entity.model.GoogleResponse;
import com.eminyilmazz.casebe.exception.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Util {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    public static void validateResponse(ResponseEntity<GoogleResponse> response) throws JsonProcessingException {
        JsonNode responseBody = mapper.readTree(mapper.writeValueAsString(response.getBody()));
        if (responseBody == null || response.getStatusCode().value() != 200) {
            throw new UnknownErrorException("Unknown error occurred.");
        }

        String status = responseBody.get("status").asText();
        logger.debug("status: {}", status);

        if (status.equalsIgnoreCase("OK")) return;

        String errorMessage = responseBody.has("error_message") ? responseBody.get("error_message").asText() : null;
        logger.debug("error message: {}", errorMessage);

        switch (status) {
            case "OK":
                break;
            case "ZERO_RESULTS":
                throw new ZeroResultsException(errorMessage != null ? errorMessage : "Search returned no results.");
            case "INVALID_REQUEST":
                throw new InvalidRequestException(errorMessage != null ? errorMessage : "Invalid request.");
            case "OVER_QUERY_LIMIT":
                throw new OverQueryLimitException(errorMessage != null ? errorMessage : "Query limit exceeded.");
            case "REQUEST_DENIED":
                throw new RequestDeniedException(errorMessage != null ? errorMessage : "Request denied.");
            default:
                throw new UnknownErrorException(errorMessage != null ? errorMessage : "Unknown error occurred.");
        }
    }

    public static boolean validateCoordinates(double longitude, double latitude) {
        return longitude <= 180. && longitude >= -180. && latitude <= 90. && latitude >= -90.;
    }
}
