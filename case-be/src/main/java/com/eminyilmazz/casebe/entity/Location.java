package com.eminyilmazz.casebe.entity;

import com.eminyilmazz.casebe.entity.dto.PlaceDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "radius")
    private double radius;
    @Column(name = "places")
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Place> places;
}