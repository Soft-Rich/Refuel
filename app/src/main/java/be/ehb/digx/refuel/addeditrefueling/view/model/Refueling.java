package be.ehb.digx.refuel.addeditrefueling.view.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;


/**
 * Created by richsoft on 17/11/2016.
 */

public class Refueling extends BaseObservable{

    private String time;
    private String date;
    private String vehicleId;
    private String fuelType;
    private String fueledVolume;
    private String literPrice;
    private String mileAge;
    private boolean external;

    public Refueling() {
    }

    public Refueling(boolean external, String fueledVolume, String fuelType, String literPrice, String mileAge, String time, String date, String vehicleId) {
        this.external = external;
        this.fueledVolume = fueledVolume;
        this.fuelType = fuelType;
        this.literPrice = literPrice;
        this.mileAge = mileAge;
        this.time = time;
        this.date = date;
        this.vehicleId = vehicleId;
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

    @Bindable
    public TextWatcher onFueledVolumeChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            setFueledVolume(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };



    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Bindable
    public TextWatcher onFuelTypeChanged = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            setFuelType(charSequence.toString());
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public String getLiterPrice() {
        return literPrice;
    }

    public void setLiterPrice(String literPrice) {
        this.literPrice = literPrice;
    }

    @Bindable
    public TextWatcher onLiterPriceChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            setLiterPrice(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public String getMileAge() {
        return mileAge;
    }

    public void setMileAge(String mileAge) {
        this.mileAge = mileAge;
    }

    @Bindable
    public TextWatcher onMileAgeChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            setMileAge(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

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