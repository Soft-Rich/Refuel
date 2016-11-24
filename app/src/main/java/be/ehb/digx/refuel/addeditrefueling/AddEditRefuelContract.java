package be.ehb.digx.refuel.addeditrefueling;

import be.ehb.digx.refuel.BasePresenter;
import be.ehb.digx.refuel.BaseView;
import be.ehb.digx.refuel.addeditrefueling.view.model.Refueling;
import be.ehb.digx.refuel.login.LoginPresenter;

/**
 * Created by richsoft on 20/11/2016.
 */

public interface AddEditRefuelContract {

    interface Presenter extends BasePresenter {

        void addRefueling(Refueling refueling);

    }

    interface View extends BaseView<LoginPresenter> {

        void showAddEditRefuelSuccesfull();
        void showAddEditRefuelFailed(AddEditRefuelException addEditRefuelException);
        void showTimestampError(String message);
        void showVehicleIdError(String message);
        void showFuelTypeError(String message);
        void showFueledVolumeError(String message);
        void showLiterPriceError(String message);
        void showMileAgeError(String message);
        void showExternalError(String message);
        void doResetInputError();
        void showProgress();
        void dismissProgress();

    }
}
