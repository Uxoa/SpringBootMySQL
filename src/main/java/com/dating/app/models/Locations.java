package com.dating.app.models;

import java.util.Objects;

public class Locations {
    
    private String locationId;
    private String locationName;
    
    public Locations() {
    }
    
    public Locations(String locationId, String locationName) {
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
        if (!(o instanceof Locations)) return false;
        Locations locations = (Locations) o;
        return Objects.equals(locationId, locations.locationId)
              && Objects.equals(locationName, locations.locationName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(locationId, locationName);
    }
}