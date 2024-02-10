package com.eminyilmazz.casebe.controller;

import com.eminyilmazz.casebe.entity.dto.LocationDTO;
import com.eminyilmazz.casebe.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void get(@RequestParam(name = "long") double longitude, @RequestParam(name = "lat") double latitude, @RequestParam(name = "rad", required = false, defaultValue = "0.0") double rad) {
        locationService.get(LocationDTO.builder()
                .longitude(longitude)
                .latitude(latitude)
                .radius(rad)
                .build());
    }
}
