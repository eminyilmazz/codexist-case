package com.eminyilmazz.casebe.repository;

import com.eminyilmazz.casebe.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("select (count(l) > 0) from Location l where l.latitude = :lat and l.longitude = :long and l.radius = :rad")
    boolean existsByLatitudeAndLongitudeAndRadius(@Param("lat") double latitude, @Param("long") double longitude, @Param("rad") double radius);

    @Query("select l from Location l where l.latitude = :lat and l.longitude = :long and l.radius = :rad")
    Location findByLongitudeAndLongitudeAndRadius(@Param("lat") double latitude, @Param("long") double longitude, @Param("rad") double radius);
}
