package com.apps.centralpurchasing.controller;

import com.apps.centralpurchasing.domain.Geolocation;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "route")
public class RouteController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "stream-sse")
    public Flux<ServerSentEvent<Geolocation>> streamEvents() {
        return Flux.interval(Duration.ofSeconds(10))
                .map(sequence -> ServerSentEvent.<Geolocation>builder()
                        .id(String.valueOf(sequence))
                        .event("EVENT_TYPE")
                        .data(fromCentralToDainville().get(sequence.intValue()))
                        .comment("")
                        .build()
                );
    }

    private List<Geolocation> fromCentralToDainville() {
        return Arrays.asList(
                Geolocation.builder().latitude(50.28811).longitude(2.81625).build(), // 0 / 10s
                Geolocation.builder().latitude(50.28747).longitude(2.81392).build(), // 100m / 20s
                Geolocation.builder().latitude(50.28733).longitude(2.81283).build(), // 200m / 30s
                Geolocation.builder().latitude(50.28661).longitude(2.81170).build(), // 300m / 40s
                Geolocation.builder().latitude(50.28642).longitude(2.81087).build(), // 400m / 50s
                Geolocation.builder().latitude(50.28678).longitude(2.80961).build(), // 500m / 1m

                Geolocation.builder().latitude(50.28745).longitude(2.80900).build(), // 600m / 1m 10s
                Geolocation.builder().latitude(50.28834).longitude(2.80825).build(), // 700m / 1m 20s
                Geolocation.builder().latitude(50.28895).longitude(2.80776).build(), // 800m / 1m 30s
                Geolocation.builder().latitude(50.28864).longitude(2.80686).build(), // 900m / 1m 40s
                Geolocation.builder().latitude(50.28839).longitude(2.80572).build(), // 1km / 1m 50s
                Geolocation.builder().latitude(50.28810).longitude(2.80428).build(), // 1.1km / 2m

                Geolocation.builder().latitude(50.28788).longitude(2.80302).build(), // 1.2km / 2m 10s
                Geolocation.builder().latitude(50.28806).longitude(2.80133).build(), // 1.3km / 2m 20s
                Geolocation.builder().latitude(50.28892).longitude(2.80054).build(), // 1.4km / 2m 30s
                Geolocation.builder().latitude(50.28960).longitude(2.79991).build(), // 1.5km / 2m 40s
                Geolocation.builder().latitude(50.29025).longitude(2.79930).build(), // 1.6km / 2m 50s
                Geolocation.builder().latitude(50.29116).longitude(2.79836).build(), // 1.7km / 3m


                Geolocation.builder().latitude(50.29712).longitude(2.77614).build(), // 3.5km / 7m


                Geolocation.builder().latitude(50.28204).longitude(2.73826).build() // 7.1km / 14m
        );
    }

}
