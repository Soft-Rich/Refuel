package be.ehb.digx.refuel.refuelings;

import java.util.List;

import be.ehb.digx.refuel.data.source.RefuelDataSourceException;
import be.ehb.digx.refuel.data.source.RefuelingDataSource;
import be.ehb.digx.refuel.data.source.remote.RefuelingRemoteDataSource;
import be.ehb.digx.refuel.domain.model.Refueling;
import be.ehb.digx.refuel.refuelings.view.model.RefuelingsUIAdapter;

/**
 * Created by richsoft on 25/11/2016.
 */

public class RefuelingsPresenter implements RefuelingsContract.Presenter, RefuelingDataSource.RefuelingsForVehicleCallback {

    RefuelingsContract.View view;

    public RefuelingsPresenter(RefuelingsContract.View view) {
        this.view = view;
    }

    @Override
    public void getRefuelings(String vehicleId) {
        view.showProgress();
        RefuelingRemoteDataSource.getInstance().getRefuelingsForVehicle(vehicleId, this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onReceivedSuccesfull(List<Refueling> refuelings) {
        RefuelingsUIAdapter refuelingsUIAdapter = new RefuelingsUIAdapter();
        view.hideProgress();
        view.showRefuelings(refuelingsUIAdapter.adaptToUi(refuelings));
    }

    @Override
    public void onReceivedFailed(RefuelDataSourceException refuelDataSourceException) {
        view.showErrGettingRefuelings(refuelDataSourceException.getMessage());
        view.hideProgress();
    }
}
