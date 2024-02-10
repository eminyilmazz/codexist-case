package com.eminyilmazz.casebe.service;

import com.eminyilmazz.casebe.entity.dto.LocationDTO;
import com.eminyilmazz.casebe.repository.LocationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private PlaceService placeService;
    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

    public void get(LocationDTO dto) {
        boolean doesExist = locationRepository.existsByLatitudeAndLongitudeAndRadius(dto.getLatitude(), dto.getLongitude(), dto.getRadius());
        if (!doesExist) {
            try {
                placeService.getPlaces(dto);
            } catch (JsonProcessingException e) {
                logger.error("error getting places!");
                ExceptionUtils.printRootCauseStackTrace(e);
            }
        } else {
            //TODO: get from db
        }
    }
}
