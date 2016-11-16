package be.ehb.digx.refuel.vehicles;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import be.ehb.digx.refuel.BR;
import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.databinding.LayoutVehicleBinding;
import be.ehb.digx.refuel.domain.model.Vehicle;

public class VehicleRecyclerViewAdapter extends RecyclerView.Adapter<VehicleRecyclerViewAdapter.VehicleViewHolder> {

    List<Vehicle> vehicles;

    public VehicleRecyclerViewAdapter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public VehicleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_vehicle, parent, false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VehicleViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.vehicle, vehicles.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder {
        private LayoutVehicleBinding binding;

        public VehicleViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

}
