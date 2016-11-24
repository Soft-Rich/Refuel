package be.ehb.digx.refuel.addeditrefueling.view.model;

import be.ehb.digx.refuel.domain.model.Refueling;
import be.ehb.digx.refuel.util.DateTime;

/**
 * Created by richsoft on 22/11/2016.
 */

public class RefuelingAdapter {

    public static Refueling adaptFromUi(be.ehb.digx.refuel.addeditrefueling.view.model.Refueling uiRefueling){
        Refueling refueling = new Refueling();
        refueling.setExternal(false);
        refueling.setFuelType(uiRefueling.getFuelType());
        refueling.setVehicleId(uiRefueling.getVehicleId());
        refueling.setFueledVolume(Double.parseDouble(uiRefueling.getFueledVolume()));
        refueling.setLiterPrice(Double.parseDouble(uiRefueling.getLiterPrice()));
        refueling.setMileAge(Long.parseLong(uiRefueling.getMileAge()));
        refueling.setTimestamp(DateTime.getTimestamp(uiRefueling.getDate(), uiRefueling.getTime()));
        return refueling;
    }

    public static be.ehb.digx.refuel.addeditrefueling.view.model.Refueling adaptToUi(Refueling refueling){
        be.ehb.digx.refuel.addeditrefueling.view.model.Refueling uiRefueling = new be.ehb.digx.refuel.addeditrefueling.view.model.Refueling();
        uiRefueling.setExternal(false);
        uiRefueling.setFuelType(uiRefueling.getFuelType());
        uiRefueling.setVehicleId(uiRefueling.getVehicleId());
        uiRefueling.setFueledVolume(String.valueOf(refueling.getFueledVolume()));
        uiRefueling.setLiterPrice(String.valueOf(refueling.getLiterPrice()));
        uiRefueling.setMileAge(String.valueOf(refueling.getMileAge()));
        return uiRefueling;
    }
}
