package com.eminyilmazz.casebe.entity.model;

import com.eminyilmazz.casebe.entity.dto.PlaceDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleResponse {
    @JsonProperty("results")
    private List<PlaceDTO> results;
    @JsonProperty("status")
    private String status;
}
