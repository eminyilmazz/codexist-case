package com.eminyilmazz.casebe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "places")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Place implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "business_status")
    private String businessStatus;
    @Column(name = "name")
    private String name;
    @Column(name = "place_id")
    private String placeId;
    @Column(name = "price_level")
    private Integer priceLevel;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "user_ratings_total")
    private Integer userRatingsTotal;
    @Column(name = "vicinity")
    private String vicinity;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
