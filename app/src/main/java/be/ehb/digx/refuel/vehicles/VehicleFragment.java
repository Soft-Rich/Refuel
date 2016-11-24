package be.ehb.digx.refuel.vehicles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.domain.model.Vehicle;
import be.ehb.digx.refuel.login.LoginPresenter;

public class VehicleFragment extends Fragment implements VehiclesContract.View{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    VehicleRecyclerViewAdapter vehicleRecyclerViewAdapter;
    VehiclesPresenter vehiclesPresenter;
    ProgressBar progressBar;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_vehicles_list, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vehiclesPresenter = new VehiclesPresenter(this);
        vehiclesPresenter.getVehicles();

        recyclerView = (RecyclerView)view.findViewById(R.id.fv_recycleview_vehicles);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        vehicleRecyclerViewAdapter = new VehicleRecyclerViewAdapter(this.getContext());
        recyclerView.setAdapter(vehicleRecyclerViewAdapter);
    }

    @Override
    public void showVehicles(List<Vehicle> vehicles) {
        vehicleRecyclerViewAdapter.setVehicles(vehicles);
        vehicleRecyclerViewAdapter.notifyDataSetChanged();
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
}