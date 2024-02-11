package com.eminyilmazz.casebe.controller;

import com.eminyilmazz.casebe.entity.dto.LocationDTO;
import com.eminyilmazz.casebe.entity.dto.PlaceDTO;
import com.eminyilmazz.casebe.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    LocationService locationService;

    @CrossOrigin(origins = "*") // Allow requests from any origin
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlaceDTO> get(@RequestParam(name = "long") double longitude, @RequestParam(name = "lat") double latitude, @RequestParam(name = "rad", required = false, defaultValue = "1000.0") int rad) {

        return locationService.get(LocationDTO.builder()
                .longitude(longitude)
                .latitude(latitude)
                .radius(rad)
                .build());
    }
}
