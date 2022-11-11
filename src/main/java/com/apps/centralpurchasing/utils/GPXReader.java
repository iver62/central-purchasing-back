package com.apps.centralpurchasing.utils;

import com.apps.centralpurchasing.domain.Geolocation;
import com.apps.centralpurchasing.domain.TrackPoint;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GPXReader extends DefaultHandler {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private final List<TrackPoint> trackPoints = new ArrayList<>();
    private final StringBuilder builder = new StringBuilder();
    private double lat;
    private double lon;
    private double ele;
    private LocalDateTime time;

    public static TrackPoint[] readTrack(InputStream in) throws IOException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            SAXParser parser = factory.newSAXParser();
            GPXReader reader = new GPXReader();
            parser.parse(in, reader);
            return reader.getTrackPoints();
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static TrackPoint[] readTrack(File file) throws IOException {
        try (InputStream in = new FileInputStream(file)) {
            return readTrack(in);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        builder.setLength(0);
        if (qName.equals("trkpt")) {
            lat = Double.parseDouble(attributes.getValue("lat"));
            lon = Double.parseDouble(attributes.getValue("lon"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("trkpt")) {
            trackPoints.add(
                    TrackPoint.builder()
                            .geolocation(
                                    Geolocation.builder()
                                            .latitude(lat)
                                            .longitude(lon)
                                            .build()
                            )
                            .dateTime(time)
                            .build()
            );
        } else if (qName.equals("ele")) {
            ele = Double.parseDouble(builder.toString());
        } else if (qName.equals("")) {
            time = LocalDateTime.parse(builder.toString(), formatter);
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        builder.append(chars, start, length);
    }

    private TrackPoint[] getTrackPoints() {
        return trackPoints.toArray(new TrackPoint[0]);
    }
}
