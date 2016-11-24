package be.ehb.digx.refuel.addeditrefueling.view.model;

import android.content.Context;

import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.RefuelApplication;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidExternalEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidFuelTypeEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidFueledVolumeEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidLiterPriceEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidMileAgeEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidVehicleIdEvent;
import be.ehb.digx.refuel.domain.model.Validator;
import de.greenrobot.event.EventBus;

/**
 * Created by richsoft on 23/11/2016.
 */

public class RefuelingValidator implements Validator<Refueling> {

    static  Context context = RefuelApplication.getContext();

    public boolean externalIsValid(boolean external){
        EventBus.getDefault().post(new InvalidExternalEvent(context.getString(R.string.error_field_required)));
        return true;
    }

    public boolean fuelTypeIsValid(String fuelType){
        if (fuelType == null || fuelType.length() == 0) {
            EventBus.getDefault().post(new InvalidFuelTypeEvent(context.getString(R.string.error_field_required)));
            return false;
        }
        return true;
    }

    public boolean vehicleIdIsValid(String vehicleId){
        if (vehicleId == null || vehicleId.length() == 0) {
            EventBus.getDefault().post(new InvalidVehicleIdEvent(context.getString(R.string.error_field_required)));
            return false;
        }
        return true;
    }

    public boolean fueledVolumeIsValid(String fueledVolume){
        Double minValue = 0d;
        Double maxValue = 1000d;
        Double fueledVolumeNumber;
        if (fueledVolume == null || fueledVolume.length() == 0) {
            EventBus.getDefault().post(new InvalidFueledVolumeEvent(context.getString(R.string.error_field_required)));
            return false;
        }

        try {
            fueledVolumeNumber = Double.valueOf(fueledVolume);
        }catch (Exception e){
            EventBus.getDefault().post(new InvalidFueledVolumeEvent(context.getString(R.string.error_number_invalid)));
            return false;
        }

        if (fueledVolumeNumber <= minValue || fueledVolumeNumber >= maxValue){
            EventBus.getDefault().post(new InvalidFueledVolumeEvent(context.getString(R.string.error_number_must_between)+minValue+" "+context.getString(R.string.label_and) +" "+maxValue));
            return false;
        }

        return true;
    }

    public boolean literPriceIsValid(String literPrice){
        Double minValue = 0d;
        Double maxValue = 99d;
        Double literPriceNumber;
        if (literPrice == null || literPrice.length() == 0) {
            EventBus.getDefault().post(new InvalidLiterPriceEvent(context.getString(R.string.error_field_required)));
            return false;
        }

        try {
            literPriceNumber = Double.valueOf(literPrice);
        }catch (Exception e){
            EventBus.getDefault().post(new InvalidLiterPriceEvent(context.getString(R.string.error_number_invalid)));
            return false;
        }

        if (literPriceNumber <= minValue || literPriceNumber >= maxValue){
            EventBus.getDefault().post(new InvalidLiterPriceEvent(context.getString(R.string.error_number_must_between)+minValue+" "+context.getString(R.string.label_and) +" "+maxValue));
            return false;
        }

        return true;
    }

    //Todo toevoegen controler of kilometerstand groter is dan deze bij vorige tankbeurt
    public boolean mileAgeIsValid(String mileAge){
        Integer minValue = 0;
        Integer maxValue = 999999;
        Integer mileAgeNumber;
        if (mileAge == null || mileAge.length() == 0) {
            EventBus.getDefault().post(new InvalidMileAgeEvent(context.getString(R.string.error_field_required)));
            return false;
        }

        try {
            mileAgeNumber = Integer.valueOf(mileAge);
        }catch (Exception e){
            EventBus.getDefault().post(new InvalidMileAgeEvent(context.getString(R.string.error_number_invalid)));
            return false;
        }

        if (mileAgeNumber <= minValue || mileAgeNumber >= maxValue){
            EventBus.getDefault().post(new InvalidMileAgeEvent(context.getString(R.string.error_number_must_between)+minValue+" "+context.getString(R.string.label_and) +" "+maxValue));
            return false;
        }

        return true;
    }

    @Override
    public boolean validate(Refueling refueling) {
        if (!externalIsValid(refueling.getExternal())){
            return false;
        }

        if (!vehicleIdIsValid(refueling.getVehicleId())){
            return false;
        }

        if (!fueledVolumeIsValid(refueling.getFueledVolume())){
            return false;
        }

        if (!fuelTypeIsValid(refueling.getFuelType())){
            return false;
        }

        if (!mileAgeIsValid(refueling.getMileAge())){
            return false;
        }

        if (!literPriceIsValid(refueling.getLiterPrice())){
            return false;
        }

        return true;
    }
}
