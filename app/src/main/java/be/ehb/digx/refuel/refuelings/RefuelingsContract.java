package be.ehb.digx.refuel.refuelings;

import java.util.List;

import be.ehb.digx.refuel.BasePresenter;
import be.ehb.digx.refuel.BaseView;
import be.ehb.digx.refuel.login.LoginPresenter;
import be.ehb.digx.refuel.refuelings.view.model.RefuelingsUI;

/**
 * Created by richsoft on 25/11/2016.
 */

public class RefuelingsContract {

    interface Presenter extends BasePresenter {
        void getRefuelings(String vehicleId);
    }

    interface View extends BaseView<LoginPresenter> {
        void showRefuelings(List<RefuelingsUI> refuelings);
        void showErrGettingRefuelings(String message);
        void showProgress();
        void hideProgress();

    }
}
