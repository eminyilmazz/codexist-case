package com.eminyilmazz.casebe.entity.dto;

import com.eminyilmazz.casebe.entity.Place;
import com.eminyilmazz.casebe.entity.model.OpeningHours;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDTO implements Serializable {
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

    public static PlaceDTO fromEntity(Place place) {
        return PlaceDTO.builder()
                .businessStatus(place.getBusinessStatus())
                .name(place.getName())
                .placeId(place.getPlaceId())
                .priceLevel(place.getPriceLevel())
                .rating(place.getRating())
                .userRatingsTotal(place.getUserRatingsTotal())
                .vicinity(place.getVicinity())
                .build();
    }

    public Place toEntity() {
        return Place.builder()
                .businessStatus(this.businessStatus)
                .name(this.name)
                .placeId(this.placeId)
                .priceLevel(this.priceLevel)
                .rating(this.rating)
                .userRatingsTotal(this.userRatingsTotal)
                .vicinity(this.vicinity)
                .build();
    }
}

