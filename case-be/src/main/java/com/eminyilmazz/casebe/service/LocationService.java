package com.eminyilmazz.casebe.service;

import com.eminyilmazz.casebe.entity.Location;
import com.eminyilmazz.casebe.entity.dto.LocationDTO;
import com.eminyilmazz.casebe.entity.dto.PlaceDTO;
import com.eminyilmazz.casebe.exception.InvalidRequestException;
import com.eminyilmazz.casebe.repository.LocationRepository;
import com.eminyilmazz.casebe.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Collections;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private PlaceService placeService;
    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

    @Cacheable(value = "places", key = "#dto.toString()", cacheManager = "cacheManager")
    public List<PlaceDTO> get(LocationDTO dto) {
        final boolean isValidCoordinate = Util.validateCoordinates(dto.getLongitude(), dto.getLatitude());
        if (!isValidCoordinate) {
            throw new InvalidRequestException("Invalid coordinates! Longitude must be between -180 and 180 and latitude must be between -90 and 90.");
        }

        boolean doesExist = locationRepository.existsByLatitudeAndLongitudeAndRadius(dto.getLatitude(), dto.getLongitude(), dto.getRadius());
        if (!doesExist) {
            try {
                List<PlaceDTO> places = placeService.getPlaces(dto);
                save(dto, places);
                return places;
            } catch (JsonProcessingException e) {
                logger.error("error getting places!");
                ExceptionUtils.printRootCauseStackTrace(e);
                return Collections.emptyList();
            }
        } else {
            return locationRepository.findByLongitudeAndLongitudeAndRadius(dto.getLatitude(), dto.getLongitude(), dto.getRadius()).getPlaces().stream().map(PlaceDTO::fromEntity).toList();
        }
    }

    private void save(LocationDTO dto, List<PlaceDTO> places) {
        Location location = dto.toEntity();
        locationRepository.save(location);
        placeService.save(places, location);
    }

    @CacheEvict(value = "places", key = "#dto.toString()", cacheManager = "cacheManager")
    public void evictCache(LocationDTO dto) {
    }
}
