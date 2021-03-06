package be.ehb.digx.refuel.addeditrefueling.view.model;

import android.databinding.BaseObservable;


/**
 * Created by richsoft on 17/11/2016.
 */

public class RefuelingUI extends BaseObservable{

    private Long id;
    private String time;
    private String date;
    private String vehicleId;
    private String fuelType;
    private String fueledVolume;
    private String literPrice;
    private String mileAge;
    private boolean external;

    public RefuelingUI() {
    }

    public RefuelingUI(Long id, boolean external, String fueledVolume, String fuelType, String literPrice, String mileAge, String time, String date, String vehicleId) {
        this.id = id;
        this.external = external;
        this.fueledVolume = fueledVolume;
        this.fuelType = fuelType;
        this.literPrice = literPrice;
        this.mileAge = mileAge;
        this.time = time;
        this.date = date;
        this.vehicleId = vehicleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }

    public String getFueledVolume() {
        return fueledVolume;
    }

    public void setFueledVolume(String fueledVolume) {
        this.fueledVolume = fueledVolume;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getLiterPrice() {
        return literPrice;
    }

    public void setLiterPrice(String literPrice) {
        this.literPrice = literPrice;
    }

    public String getMileAge() {
        return mileAge;
    }

    public void setMileAge(String mileAge) {
        this.mileAge = mileAge;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}