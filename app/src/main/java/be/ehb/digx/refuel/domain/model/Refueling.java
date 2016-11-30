package be.ehb.digx.refuel.domain.model;

import android.databinding.BaseObservable;

import java.io.Serializable;

/**
 * Created by richsoft on 17/11/2016.
 */

public class Refueling extends BaseObservable implements Serializable{

    private Long id;
    private Long timestamp;
    private String vehicleId;
    private String fuelType;
    private Double fueledVolume;
    private Double literPrice;
    private Long mileAge;
    private Boolean external;

    public Refueling() {
    }

    public Refueling(Long id, Boolean external, Double fueledVolume, String fuelType, Double literPrice, Long mileAge, Long timestamp, String vehicleId) {
        this.id = id;
        this.external = external;
        this.fueledVolume = fueledVolume;
        this.fuelType = fuelType;
        this.literPrice = literPrice;
        this.mileAge = mileAge;
        this.timestamp = timestamp;
        this.vehicleId = vehicleId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    public Double getFueledVolume() {
        return fueledVolume;
    }

    public void setFueledVolume(Double fueledVolume) {
        this.fueledVolume = fueledVolume;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Double getLiterPrice() {
        return literPrice;
    }

    public void setLiterPrice(Double literPrice) {
        this.literPrice = literPrice;
    }

    public Long getMileAge() {
        return mileAge;
    }

    public void setMileAge(Long mileAge) {
        this.mileAge = mileAge;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}