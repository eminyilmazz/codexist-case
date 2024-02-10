package com.eminyilmazz.casebe.entity.dto;

import com.eminyilmazz.casebe.entity.Place;
import com.eminyilmazz.casebe.entity.model.OpeningHours;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDTO {
    @JsonProperty("business_status")
    private String businessStatus;
    @JsonProperty("name")
    private String name;
    @JsonProperty("opening_hours")
    private OpeningHours openingHours;
    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("price_level")
    private Integer priceLevel;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("user_ratings_total")
    private Integer userRatingsTotal;
    @JsonProperty("vicinity")
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

