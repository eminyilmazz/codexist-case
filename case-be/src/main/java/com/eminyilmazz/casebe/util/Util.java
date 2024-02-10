package com.eminyilmazz.casebe.util;

import com.eminyilmazz.casebe.entity.dto.PlaceDTO;
import com.eminyilmazz.casebe.entity.model.GoogleResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Util {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<PlaceDTO> parseResponse(String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        GoogleResponse response = mapper.readValue(body, GoogleResponse.class);
        return response.getResults();
    }
}
