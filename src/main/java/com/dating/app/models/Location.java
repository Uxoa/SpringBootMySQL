package com.dating.app.models;

import java.util.Objects;

public class Location {
    
    private String locationId;
    private String locationName;
    
    public Location() {
    }
    
    public Location(String locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }
    
    public String getLocationId() {
        return locationId;
    }
    
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
    
    public String getLocationName() {
        return locationName;
    }
    
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location locations = (Location) o;
        return Objects.equals(locationId, locations.locationId)
              && Objects.equals(locationName, locations.locationName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(locationId, locationName);
    }
}