package be.ehb.digx.refuel.addeditrefueling.view.model;

import be.ehb.digx.refuel.BaseAdapter;
import be.ehb.digx.refuel.domain.model.Refueling;
import be.ehb.digx.refuel.util.DateTime;

/**
 * Created by richsoft on 22/11/2016.
 */

public class RefuelingAdapter implements BaseAdapter<RefuelingUI, Refueling> {

    public Refueling adaptFromUi(RefuelingUI uiRefueling){
        Refueling refueling = new Refueling();
        refueling.setExternal(refueling.getExternal());
        refueling.setFuelType(uiRefueling.getFuelType());
        refueling.setVehicleId(uiRefueling.getVehicleId());
        refueling.setFueledVolume(Double.parseDouble(uiRefueling.getFueledVolume()));
        refueling.setLiterPrice(Double.parseDouble(uiRefueling.getLiterPrice()));
        refueling.setMileAge(Long.parseLong(uiRefueling.getMileAge()));
        refueling.setTimestamp(DateTime.getTimestamp(uiRefueling.getDate(), uiRefueling.getTime()));
        return refueling;
    }

    public RefuelingUI adaptToUi(Refueling refueling){
        RefuelingUI refuelingUI = new RefuelingUI();
        refuelingUI.setExternal(refueling.getExternal());
        refuelingUI.setFuelType(refueling.getFuelType());
        refuelingUI.setVehicleId(refueling.getVehicleId());
        refuelingUI.setFueledVolume(String.valueOf(refueling.getFueledVolume()));
        refuelingUI.setLiterPrice(String.valueOf(refueling.getLiterPrice()));
        refuelingUI.setMileAge(String.valueOf(refueling.getMileAge()));
        return refuelingUI;
    }
}
