package be.ehb.digx.refuel.domain.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

/**
 * Created by richsoft on 17/11/2016.
 */

public class Refueling extends BaseObservable implements Serializable{

    private Long timestamp;
    private String vehicleId;
    private String fuelType;
    private Double fueledVolume;
    private Double literPrice;
    private Long mileAge;
    private Boolean external;

    public Refueling() {
    }

    public Refueling(Boolean external, Double fueledVolume, String fuelType, Double literPrice, Long mileAge, Long timestamp, String vehicleId) {
        this.external = external;
        this.fueledVolume = fueledVolume;
        this.fuelType = fuelType;
        this.literPrice = literPrice;
        this.mileAge = mileAge;
        this.timestamp = timestamp;
        this.vehicleId = vehicleId;
    }

    @Bindable
    public Boolean getExternal() {
        return external;
    }

    @Bindable
    public void setExternal(Boolean external) {
        this.external = external;
    }

    @Bindable
    public Double getFueledVolume() {
        return fueledVolume;
    }

    @Bindable
    public void setFueledVolume(Double fueledVolume) {
        this.fueledVolume = fueledVolume;
    }

    @Bindable
    public String getFuelType() {
        return fuelType;
    }

    @Bindable
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


    @Bindable
    public Double getLiterPrice() {
        return literPrice;
    }

    @Bindable
    public void setLiterPrice(Double literPrice) {
        this.literPrice = literPrice;
    }

    @Bindable
    public Long getMileAge() {
        return mileAge;
    }

    @Bindable
    public void setMileAge(Long mileAge) {
        this.mileAge = mileAge;
    }

    @Bindable
    public Long getTimestamp() {
        return timestamp;
    }

    @Bindable
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Bindable
    public String getVehicleId() {
        return vehicleId;
    }

    @Bindable
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}