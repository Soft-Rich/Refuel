package be.ehb.digx.refuel.refuelings.view.model;

import java.util.ArrayList;
import java.util.List;

import be.ehb.digx.refuel.BaseAdapter;
import be.ehb.digx.refuel.domain.model.Refueling;
import be.ehb.digx.refuel.util.DateTime;

/**
 * Created by richsoft on 25/11/2016.
 */

public class RefuelingsUIAdapter implements BaseAdapter<List<RefuelingsUI>, List<Refueling>>
{
    @Override
    public List<Refueling> adaptFromUi(List<RefuelingsUI> refuelingUiList) {
        List<Refueling> refuelings = new ArrayList<>();
        for (RefuelingsUI refuelingUi:refuelingUiList) {
            Refueling refueling = new Refueling();
            refueling.setId(refuelingUi.getId());
            refueling.setTimestamp(refuelingUi.getTimestamp());
            refueling.setExternal(refuelingUi.getExternal());
            refueling.setFuelType(refuelingUi.getFuelType());
            refueling.setVehicleId(refuelingUi.getVehicleId());
            refueling.setFueledVolume(Double.parseDouble(refuelingUi.getFueledVolume()));
            refueling.setLiterPrice(Double.parseDouble(refuelingUi.getLiterPrice()));
            refueling.setMileAge(Long.parseLong(refuelingUi.getMileAge()));
            refueling.setTimestamp(DateTime.getTimestamp(refuelingUi.getDate(), refuelingUi.getTime()));
            refuelings.add(refueling);
        }
        return refuelings;
    }

    @Override
    public List<RefuelingsUI> adaptToUi(List<Refueling> refulings) {
        List<RefuelingsUI> refuelingsUIList = new ArrayList<>();
        for (Refueling refueling:refulings) {
            RefuelingsUI refuelingsUI = new RefuelingsUI();
            refuelingsUI.setId(refueling.getId());
            refuelingsUI.setTimestamp(refueling.getTimestamp());
            //refuelingsUI.setExternal(refueling.getExternal());
            refuelingsUI.setFuelType(refueling.getFuelType());
            refuelingsUI.setVehicleId(refueling.getVehicleId());
            refuelingsUI.setFueledVolume(String.valueOf(refueling.getFueledVolume()));
            refuelingsUI.setLiterPrice(String.valueOf(refueling.getLiterPrice()));
            refuelingsUI.setMileAge(String.valueOf(refueling.getMileAge()));
            refuelingsUI.setDate(DateTime.getDate(refueling.getTimestamp()));
            refuelingsUI.setTime(DateTime.getTime(refueling.getTimestamp()));
            refuelingsUI.setDateHeaderFormat(DateTime.getMothYear(refueling.getTimestamp()));
            refuelingsUIList.add(refuelingsUI);
        }
        return refuelingsUIList;
    }
}
