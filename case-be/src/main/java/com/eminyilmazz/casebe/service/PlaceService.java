package com.eminyilmazz.casebe.service;

import com.eminyilmazz.casebe.entity.Location;
import com.eminyilmazz.casebe.entity.Place;
import com.eminyilmazz.casebe.entity.dto.LocationDTO;
import com.eminyilmazz.casebe.entity.dto.PlaceDTO;
import com.eminyilmazz.casebe.entity.model.GoogleResponse;
import com.eminyilmazz.casebe.repository.PlaceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(PlaceService.class);
    private final PlaceRepository placeRepository;
    private final APIService apiService;

    public PlaceService(PlaceRepository placeRepository, APIService apiService) {
        this.placeRepository = placeRepository;
        this.apiService = apiService;
    }

    public List<PlaceDTO> getPlaces(LocationDTO dto) throws JsonProcessingException {
        GoogleResponse resp = apiService.searchNearbyPlaces(dto.getLatitude(), dto.getLongitude(), (int) dto.getRadius());
        List<PlaceDTO> places = resp.getResults();
        logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(places));
        return places;
    }

    protected void save(List<PlaceDTO> dto, Location location) {
        List<Place> places = dto.stream()
                        .map(PlaceDTO::toEntity)
                        .toList();
        for (Place place : places) {
            place.setLocation(location);
        }
        placeRepository.saveAll(places);
    }
}
