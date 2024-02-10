package com.eminyilmazz.casebe.entity.dto;

import com.eminyilmazz.casebe.entity.Place;
import com.eminyilmazz.casebe.entity.model.OpeningHours;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDTO {
    private String businessStatus;
    private String name;
    private OpeningHours openingHours;
    private String placeId;
    private Integer priceLevel;
    private Double rating;
    private Integer userRatingsTotal;
    private String vicinity;

    public PlaceDTO(String businessStatus, String name, String placeId, Integer priceLevel, Double rating, Integer userRatingsTotal, String vicinity) {
    }

    public static PlaceDTO fromEntity(Place place) {
        return new PlaceDTO(
                place.getBusinessStatus(),
                place.getName(),
                place.getPlaceId(),
                place.getPriceLevel(),
                place.getRating(),
                place.getUserRatingsTotal(),
                place.getVicinity()
        );
    }

    public Place toEntity() {
        Place place = new Place();
        place.setBusinessStatus(this.businessStatus);
        place.setName(this.name);
        place.setPlaceId(this.placeId);
        place.setPriceLevel(this.priceLevel);
        place.setRating(this.rating);
        place.setUserRatingsTotal(this.userRatingsTotal);
        place.setVicinity(this.vicinity);
        return place;
    }
}

