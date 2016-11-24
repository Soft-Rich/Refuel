package be.ehb.digx.refuel.addeditrefueling;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Date;
import java.util.Calendar;

import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.RefuelApplication;
import be.ehb.digx.refuel.RefuelApplicationConstants;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidExternalEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidFuelTypeEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidFueledVolumeEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidLiterPriceEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidMileAgeEvent;
import be.ehb.digx.refuel.addeditrefueling.event.InvalidVehicleIdEvent;
import be.ehb.digx.refuel.addeditrefueling.view.model.Refueling;
import be.ehb.digx.refuel.databinding.LayoutAddeditRefuelBinding;
import be.ehb.digx.refuel.dialog.ProgressDialogFragment;
import be.ehb.digx.refuel.login.LoginPresenter;
import be.ehb.digx.refuel.util.DateTime;
import de.greenrobot.event.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditRefuelingFragment extends Fragment implements AddEditRefuelContract.View {
    
    private static final String TAG = "AddEditRefuelingFrag";

    LayoutAddeditRefuelBinding layoutAddeditRefuelBinding;
    AddEditRefuelPresenter addEditRefuelPresenter;
    Refueling refueling;
    ProgressDialogFragment progressDialogFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutAddeditRefuelBinding = DataBindingUtil.inflate(inflater, R.layout.layout_addedit_refuel, container, false);
        View rootview = layoutAddeditRefuelBinding.getRoot();
        progressDialogFragment = new ProgressDialogFragment();
        progressDialogFragment.setContext(getActivity());

        refueling = new Refueling();
        Intent intent = getActivity().getIntent();
        String vehicleId = intent.getStringExtra(RefuelApplicationConstants.EXTRAS_VEHICLE_ID);
        String fuelType = intent.getStringExtra(RefuelApplicationConstants.EXTRAS_FUELTYPE);
        refueling.setVehicleId(vehicleId);
        refueling.setFuelType(fuelType);
        refueling.setTime(DateTime.getCurrentTime());
        refueling.setDate(DateTime.getCurrentDate());

        layoutAddeditRefuelBinding.setRefueling(refueling);
        addEditRefuelPresenter = new AddEditRefuelPresenter(this);
        layoutAddeditRefuelBinding.setPresenter(addEditRefuelPresenter);
        layoutAddeditRefuelBinding.setHandler(this);

        EventBus.getDefault().register(this);
        return rootview;
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showAddEditRefuelSuccesfull() {
        Toast.makeText(RefuelApplication.getContext(), R.string.result_refueling_saved_succesful, Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    @Override
    public void showAddEditRefuelFailed(AddEditRefuelException addEditRefuelException) {

    }

    @Override
    public void showTimestampError(String message) {
        layoutAddeditRefuelBinding.aevTime.setError(message);
        layoutAddeditRefuelBinding.aevTime.requestFocus();
    }

    @Override
    public void showVehicleIdError(String message) {
        showErrorDialog(message);
    }

    @Override
    public void showFuelTypeError(String message) {
        layoutAddeditRefuelBinding.aevFuelType.setError(message);
        layoutAddeditRefuelBinding.aevFuelType.requestFocus();
    }

    @Override
    public void showFueledVolumeError(String message) {
        layoutAddeditRefuelBinding.aevFueledVolume.setError(message);
        layoutAddeditRefuelBinding.aevFueledVolume.requestFocus();
    }

    @Override
    public void showLiterPriceError(String message) {
        layoutAddeditRefuelBinding.aevLiterPrice.setError(message);
        layoutAddeditRefuelBinding.aevLiterPrice.requestFocus();
    }

    @Override
    public void showMileAgeError(String message) {
        layoutAddeditRefuelBinding.aevMileAge.setError(message);
        layoutAddeditRefuelBinding.aevMileAge.requestFocus();
    }

    @Override
    public void showExternalError(String message) {
        layoutAddeditRefuelBinding.aevExternal.setError(message);
        layoutAddeditRefuelBinding.aevExternal.requestFocus();
    }

    @Override
    public void doResetInputError() {
        layoutAddeditRefuelBinding.aevFueledVolume.setError(null);
        layoutAddeditRefuelBinding.aevFuelType.setError(null);
        layoutAddeditRefuelBinding.aevLiterPrice.setError(null);
        layoutAddeditRefuelBinding.aevMileAge.setError(null);
        layoutAddeditRefuelBinding.aevTime.setError(null);
        layoutAddeditRefuelBinding.aevDate.setError(null);
        layoutAddeditRefuelBinding.aevExternal.setError(null);
    }

    @Override
    public void showProgress() {
        progressDialogFragment.show(getActivity().getFragmentManager(), TAG);
    }

    @Override
    public void dismissProgress() {
        progressDialogFragment.dismiss();
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {

    }

    private void showErrorDialog(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(this.getContext()).create();
        alertDialog.setTitle(R.string.label_error);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }

    public void onEvent(InvalidExternalEvent event){
        showExternalError(event.getMessage());
    }

    public void onEvent(InvalidFueledVolumeEvent event){
        showFueledVolumeError(event.getMessage());
    }

    public void onEvent(InvalidFuelTypeEvent event){
        showFuelTypeError(event.getMessage());
    }

    public void onEvent(InvalidLiterPriceEvent event){
        showLiterPriceError(event.getMessage());
    }

    public void onEvent(InvalidMileAgeEvent event){
        showMileAgeError(event.getMessage());
    }

    public void onEvent(InvalidVehicleIdEvent event){
        showVehicleIdError(event.getMessage());
    }

    public void onDateClicked(String date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateTime.getDateFromString(date));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(dayOfMonth)+"/"+String.valueOf(monthOfYear)+"/"+String.valueOf(year);
                        layoutAddeditRefuelBinding.aevDate.setText(date);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void onTimeClicked(String time){
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateTime.getTimeFromString(time));
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        String time = String.valueOf(hourOfDay)+":"+String.valueOf(minute);
                        layoutAddeditRefuelBinding.aevTime.setText(time);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }
}