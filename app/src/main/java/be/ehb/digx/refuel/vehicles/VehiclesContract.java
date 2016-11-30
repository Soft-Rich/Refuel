package be.ehb.digx.refuel.vehicles;

import java.util.List;

import be.ehb.digx.refuel.BasePresenter;
import be.ehb.digx.refuel.BaseView;
import be.ehb.digx.refuel.domain.model.Vehicle;
import be.ehb.digx.refuel.login.LoginPresenter;

/**
 * Created by richsoft on 15/11/2016.
 */

public interface VehiclesContract {

    /**
     * Created by richsoft on 15/11/2016.
     * Handles actions for vehicles overview
     */

     interface Presenter extends BasePresenter {

        void getVehicles();

    }


    /**
     * Created by richsoft on 15/11/2016.
     * Displays the vehicles information and triggers the VehiclePresenter for actions
     */

    interface View extends BaseView<LoginPresenter> {

        void showVehicles(List<Vehicle> vehicles);
        void showProgress();
        void hideProgress();

    }
}
