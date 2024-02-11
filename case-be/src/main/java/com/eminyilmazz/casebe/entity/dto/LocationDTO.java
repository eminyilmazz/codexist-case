package com.eminyilmazz.casebe.entity.dto;

import com.eminyilmazz.casebe.entity.Location;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDTO {
    private double longitude;
    private double latitude;
    private int radius;

    public static LocationDTO fromEntity(Location location) {
        return LocationDTO.builder()
                .longitude(location.getLongitude())
                .latitude(location.getLatitude())
                .radius(location.getRadius())
                .build();
    }

    public Location toEntity() {
        return Location.builder()
                .longitude(this.longitude)
                .latitude(this.latitude)
                .radius(this.radius)
                .build();
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", radius=" + radius +
                '}';
    }
}
