package com.apps.centralpurchasing.service;

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
@RequestMapping("route")
public class RouteController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "stream-sse")
    public Flux<ServerSentEvent<Geolocation>> streamEvents() {
//        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//        try {
//            SAXParser saxParser = saxParserFactory.newSAXParser();
//            MyHandler handler = new MyHandler();
//            saxParser.parse(new File("/Users/pankaj/employees.xml"), handler);
//            //Get Employees list
//            List<Employee> empList = handler.getEmpList();
//            //print employee information
//            for(Employee emp : empList)
//                System.out.println(emp);
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            e.printStackTrace();
//        }
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
                Geolocation.builder().latitude(50.28747).longitude(2.81392).build(), // 0.1km / 20s
                Geolocation.builder().latitude(50.28733).longitude(2.81283).build(), // 0.2km / 30s
                Geolocation.builder().latitude(50.28661).longitude(2.81170).build(), // 0.3km / 40s
                Geolocation.builder().latitude(50.28642).longitude(2.81087).build(), // 0.4km / 50s
                Geolocation.builder().latitude(50.28678).longitude(2.80961).build(), // 0.5km / 1m

                Geolocation.builder().latitude(50.28745).longitude(2.80900).build(), // 0.6km / 1m 10s
                Geolocation.builder().latitude(50.28834).longitude(2.80825).build(), // 0.7km / 1m 20s
                Geolocation.builder().latitude(50.28895).longitude(2.80776).build(), // 0.8mm / 1m 30s
                Geolocation.builder().latitude(50.28864).longitude(2.80686).build(), // 0.9km / 1m 40s
                Geolocation.builder().latitude(50.28839).longitude(2.80572).build(), // 1.0km / 1m 50s
                Geolocation.builder().latitude(50.28810).longitude(2.80428).build(), // 1.1km / 2m

                Geolocation.builder().latitude(50.28788).longitude(2.80302).build(), // 1.2km / 2m 10s
                Geolocation.builder().latitude(50.28806).longitude(2.80133).build(), // 1.3km / 2m 20s
                Geolocation.builder().latitude(50.28892).longitude(2.80054).build(), // 1.4km / 2m 30s
                Geolocation.builder().latitude(50.28960).longitude(2.79991).build(), // 1.5km / 2m 40s
                Geolocation.builder().latitude(50.29025).longitude(2.79930).build(), // 1.6km / 2m 50s
                Geolocation.builder().latitude(50.29116).longitude(2.79836).build(), // 1.7km / 3m

                Geolocation.builder().latitude(50.29133).longitude(2.79800).build(), // 1.8km / 3m 10s
                Geolocation.builder().latitude(50.29176).longitude(2.79677).build(), // 1.9km / 3m 20s
                Geolocation.builder().latitude(50.29210).longitude(2.79548).build(), // 2.0km / 3m 30s
                Geolocation.builder().latitude(50.29251).longitude(2.79414).build(), // 2.1km / 3m 40s
                Geolocation.builder().latitude(50.29290).longitude(2.79299).build(), // 2.2km / 3m 50s
                Geolocation.builder().latitude(50.29338).longitude(2.79180).build(), // 2.3km / 4m

                Geolocation.builder().latitude(50.29400).longitude(2.79083).build(), // 2.4km / 4m 10s
                Geolocation.builder().latitude(50.29454).longitude(2.78999).build(), // 2.5km / 4m 20s
                Geolocation.builder().latitude(50.29509).longitude(2.78876).build(), // 2.6km / 4m 30s
                Geolocation.builder().latitude(50.29553).longitude(2.78764).build(), // 2.7km / 4m 40s
                Geolocation.builder().latitude(50.29577).longitude(2.78631).build(), // 2.8km / 4m 50s
                Geolocation.builder().latitude(50.29600).longitude(2.78493).build(), // 2.9km / 5m

                Geolocation.builder().latitude(50.29651).longitude(2.78372).build(), // 3.0km / 5m 10s
                Geolocation.builder().latitude(50.29674).longitude(2.78244).build(), // 3.1km / 5m 20s
                Geolocation.builder().latitude(50.29711).longitude(2.78118).build(), // 3.2km / 5m 30s
                Geolocation.builder().latitude(50.29732).longitude(2.77986).build(), // 3.3km / 5m 40s
                Geolocation.builder().latitude(50.29730).longitude(2.77849).build(), // 3.4km / 5m 50s
                Geolocation.builder().latitude(50.29727).longitude(2.77702).build(), // 3.5km / 6m

                Geolocation.builder().latitude(50.29726).longitude(2.77563).build(), // 3.6km / 6m 10s
                Geolocation.builder().latitude(50.29723).longitude(2.77424).build(), // 3.7km / 6m 20s
                Geolocation.builder().latitude(50.29720).longitude(2.77285).build(), // 3.8km / 6m 30s
                Geolocation.builder().latitude(50.29717).longitude(2.77143).build(), // 3.9km / 6m 40s
                Geolocation.builder().latitude(50.29714).longitude(2.77003).build(), // 4.0km / 6m 50s
                Geolocation.builder().latitude(50.29707).longitude(2.76879).build(), // 4.1km / 7m

                Geolocation.builder().latitude(50.28204).longitude(2.73826).build() // 7.1km / 14m
        );
    }

}
