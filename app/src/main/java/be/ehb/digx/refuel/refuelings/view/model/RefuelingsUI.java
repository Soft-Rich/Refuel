package be.ehb.digx.refuel.refuelings.view.model;

/**
 * Created by richsoft on 25/11/2016.
 */

public class RefuelingsUI implements Comparable<RefuelingsUI>{

    private Long id;
    private Long timestamp;
    private String time;
    private String date;
    private String dateHeaderFormat;
    private String vehicleId;
    private String fuelType;
    private String fueledVolume;
    private String literPrice;
    private String mileAge;
    private boolean external;

    public RefuelingsUI() {
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

    public String getDateHeaderFormat() {
        return dateHeaderFormat;
    }

    public void setDateHeaderFormat(String dateHeaderFormat) {
        this.dateHeaderFormat = dateHeaderFormat;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(RefuelingsUI refuelingsUI) {
            if ((this.getTimestamp() - refuelingsUI.getTimestamp()) > 0) {
                return 1;
            } else if ((this.getTimestamp() - refuelingsUI.getTimestamp()) < 0) {
                return -1;
            }
        return 0;
    }

}
