package com.apps.centralpurchasing.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class TrackPoint {

    private Geolocation geolocation;
    private LocalDateTime dateTime;
}
