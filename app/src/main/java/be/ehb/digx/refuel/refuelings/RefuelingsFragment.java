package be.ehb.digx.refuel.refuelings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.RefuelApplicationConstants;
import be.ehb.digx.refuel.login.LoginPresenter;
import be.ehb.digx.refuel.refuelings.view.model.RefuelingsUI;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by richsoft on 25/11/2016.
 */

public class RefuelingsFragment extends Fragment implements RefuelingsContract.View {


    StickyListHeadersListView stickyListView;
    RefuelingsStickyListAdapter refuelingsStickyListAdapter;
    RefuelingsPresenter refuelingsPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getActivity().getIntent();
        String vehicleId = intent.getStringExtra(RefuelApplicationConstants.EXTRAS_VEHICLE_ID);
        if (vehicleId != null){
            refuelingsPresenter = new RefuelingsPresenter(this);
            refuelingsPresenter.getRefuelings(vehicleId);
        }else{
            Toast.makeText(getContext(), getString(R.string.error_missing_vehicleId), Toast.LENGTH_SHORT).show();
            showErrorVehicleIdError();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_refuelings_list, container);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refuelingsStickyListAdapter = new RefuelingsStickyListAdapter(getContext());
        stickyListView = (StickyListHeadersListView) getView().findViewById(R.id.rfv_stickyheader_refuelings);
        stickyListView.setAdapter(refuelingsStickyListAdapter);

    }

    @Override
    public void showRefuelings(final List<RefuelingsUI> refuelings) {
        Collections.sort(refuelings);
        refuelingsStickyListAdapter.setRefuelings(refuelings);
        refuelingsStickyListAdapter.notifyDataSetChanged();
        stickyListView.post(new Runnable(){
            public void run() {
                stickyListView.setSelection(refuelings.size() - 1);
            }});
    }

    @Override
    public void showErrGettingRefuelings(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setPresenter(LoginPresenter presenter) {

    }

    private void showErrorVehicleIdError(){
        getActivity().finish();
    }
}
