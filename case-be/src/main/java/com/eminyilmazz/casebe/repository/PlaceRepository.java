package com.eminyilmazz.casebe.repository;

import com.eminyilmazz.casebe.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}