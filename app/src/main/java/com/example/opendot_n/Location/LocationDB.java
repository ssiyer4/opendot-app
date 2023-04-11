package com.example.opendot_n.Location;

//creating a class that defines location in database

public class LocationDB {

    public String locationId;
    public String locationName;
    public String locationCoordinates;

    public LocationDB() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public LocationDB(String locationId, String locationName, String locationCoordinates) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationCoordinates = locationCoordinates;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationCoordinates() {
        return locationCoordinates;
    }
}
