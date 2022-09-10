package com.apps.centralpurchasing.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;

@Builder
@Data
@ToString
public class Geolocation {

    @Min(0)
    private double longitude;
    @Min(0)
    private double latitude;
}
