package be.ehb.digx.refuel.addeditrefueling;

import android.util.Log;

import be.ehb.digx.refuel.addeditrefueling.view.model.Refueling;
import be.ehb.digx.refuel.addeditrefueling.view.model.RefuelingAdapter;
import be.ehb.digx.refuel.addeditrefueling.view.model.RefuelingValidator;
import be.ehb.digx.refuel.data.source.RefuelDataSourceException;
import be.ehb.digx.refuel.data.source.RefuelingDataSource;
import be.ehb.digx.refuel.data.source.remote.RefuelingRemoteDataSource;

/**
 * Created by richsoft on 20/11/2016.
 */

public class AddEditRefuelPresenter implements AddEditRefuelContract.Presenter, RefuelingDataSource.RefuelingAddedCallback {

    private static final String TAG = "AddEditRefuelPresenter";
    AddEditRefuelContract.View addEditRefuelView;
    public AddEditRefuelPresenter(AddEditRefuelContract.View addEditRefuelView) {
        this.addEditRefuelView = addEditRefuelView;
    }

    @Override
    public void addRefueling(Refueling refueling) {
        Log.i(TAG, "addRefueling: ");
        addEditRefuelView.doResetInputError();
        RefuelingValidator refuelingValidator = new RefuelingValidator();
        if (refuelingValidator.validate(refueling)){
            addEditRefuelView.showProgress();
            RefuelingRemoteDataSource.getInstance().add(RefuelingAdapter.adaptFromUi(refueling), this);
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void onRefuelAddedSuccesfull() {
        addEditRefuelView.showAddEditRefuelSuccesfull();
        addEditRefuelView.dismissProgress();
    }

    @Override
    public void onRefuelAddedFailed(RefuelDataSourceException refuelDataSourceException) {
        addEditRefuelView.showAddEditRefuelFailed(new AddEditRefuelException(refuelDataSourceException));
        addEditRefuelView.dismissProgress();
    }
}
