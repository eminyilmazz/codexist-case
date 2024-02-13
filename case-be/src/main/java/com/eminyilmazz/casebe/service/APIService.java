package com.eminyilmazz.casebe.service;

import com.eminyilmazz.casebe.entity.model.GoogleResponse;
import com.eminyilmazz.casebe.exception.UnknownErrorException;
import com.eminyilmazz.casebe.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Service
public class APIService {
    @Value("${com.eminyilmazz.google.api.key:SECRET_KEY}")
    private String API_KEY;
    @Value("${com.eminyilmazz.google.places.url}")
    private String GOOGLE_PLACES_API_URL;

    @Autowired
    private RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(APIService.class);

    public GoogleResponse searchNearbyPlaces(double latitude, double longitude, int radius) {
        URI uri = UriComponentsBuilder.fromHttpUrl(GOOGLE_PLACES_API_URL)
                .queryParam("location", latitude + "," + longitude)
                .queryParam("radius", radius)
                .queryParam("key", API_KEY)
                .build().toUri();
        logger.debug("generated uri: {}", uri.toASCIIString());
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(header);

        ResponseEntity<GoogleResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, GoogleResponse.class);
        logger.debug("Response received - Status code: {}", response.getStatusCode());
        try {
            Util.validateResponse(response);
        } catch (JsonProcessingException e) {
            logger.error("error occurred validating response!");
            throw new UnknownErrorException(e.getMessage());
        }
        return response.getBody();
    }

}
