package com.example.android.tourguide;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by klaudia on 29/07/18.
 */

public class Attraction {
    private static final int NO_IMAGE_PROVIDED = -1;

    private String name;
    private LocalTime openingHours = null;
    private LocalTime closingHours = null;
    private LocalDate dateOfEvent = null;
    private String location;

    private int imageResourceId = NO_IMAGE_PROVIDED;

    public Attraction(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Attraction(String name, LocalTime openingHours, LocalTime closingHours, String location) {
        this(name, location);
        this.openingHours = openingHours;
        this.closingHours = closingHours;
    }

    public Attraction(String name, LocalDate date, String location, int imageResourceId) {
        this(name, location);
        this.dateOfEvent = date;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getOpeningHoursOrDate() {
        if (openingHours != null) {
            return openingHours.toString() + " - " + closingHours.toString();
        }
        else {
            return dateOfEvent.toString();
        }
    }

    public String getLocation() {
        return location;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

}
