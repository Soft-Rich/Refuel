package be.ehb.digx.refuel.domain.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

/**
 * Created by richsoft on 16/11/2016.
 */

public class Vehicle extends BaseObservable implements Serializable {

    private String carId;
    private	String numberPlate;
    private	String fuelType;
    private	String engine;
    private	String doors;
    private	String manufacturer;
    private	String color;
    private	String photoUrl;
    private	String typeOfUse;
    private	String yearOfConstruction;
    private	String model;
    private String horsePower;

    public Vehicle() {
    }

    public Vehicle(String carId, String numberPlate, String fuelType, String engine, String doors, String manufacturer, String color, String photoUrl, String typeOfUse, String yearOfConstruction, String model, String horsePower) {
        this.carId = carId;
        this.numberPlate = numberPlate;
        this.fuelType = fuelType;
        this.engine = engine;
        this.doors = doors;
        this.manufacturer = manufacturer;
        this.color = color;
        this.photoUrl = photoUrl;
        this.typeOfUse = typeOfUse;
        this.yearOfConstruction = yearOfConstruction;
        this.model = model;
        this.horsePower = horsePower;
    }

    @Bindable
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Bindable
    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Bindable
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Bindable
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Bindable
    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    @Bindable
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Bindable
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Bindable
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Bindable
    public String getTypeOfUse() {
        return typeOfUse;
    }

    public void setTypeOfUse(String typeOfUse) {
        this.typeOfUse = typeOfUse;
    }

    @Bindable
    public String getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(String yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    @Bindable
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Bindable
    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "carId='" + carId + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", engine='" + engine + '\'' +
                ", doors='" + doors + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", typeOfUse='" + typeOfUse + '\'' +
                ", yearOfConstruction='" + yearOfConstruction + '\'' +
                ", model='" + model + '\'' +
                ", horsePower='" + horsePower + '\'' +
                '}';
    }
}
