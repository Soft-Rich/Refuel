package be.ehb.digx.refuel.vehicles;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import be.ehb.digx.refuel.BR;
import be.ehb.digx.refuel.R;
import be.ehb.digx.refuel.RefuelApplicationConstants;
import be.ehb.digx.refuel.addeditrefueling.AddEditRefuelActivity;
import be.ehb.digx.refuel.databinding.LayoutVehicleItemBinding;
import be.ehb.digx.refuel.domain.model.Vehicle;
import be.ehb.digx.refuel.refuelings.RefuelingsActivity;

public class VehicleRecyclerViewAdapter extends RecyclerView.Adapter<VehicleRecyclerViewAdapter.VehicleViewHolder> {

    List<Vehicle> vehicles;
    Context context;

    public VehicleRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public VehicleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_vehicle_item, parent, false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VehicleViewHolder holder, final int position) {
        holder.getBinding().setVariable(BR.vehicle, vehicles.get(position));
        holder.getBinding().vehicleOverflowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final PopupMenu popup = new PopupMenu(v.getContext(), v, Gravity.RIGHT);
                final MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.vehilces_actions, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(final MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.add_refueling:
                                Intent addRefuelingIntent = new Intent(context, AddEditRefuelActivity.class);
                                addRefuelingIntent.putExtra(RefuelApplicationConstants.EXTRAS_VEHICLE_ID, vehicles.get(position).getCarId());
                                addRefuelingIntent.putExtra(RefuelApplicationConstants.EXTRAS_FUELTYPE, vehicles.get(position).getFuelType());
                                context.startActivity(addRefuelingIntent);
                                return true;
                            case R.id.list_refueling:
                                Intent refuelingListIntent = new Intent(context, RefuelingsActivity.class);
                                refuelingListIntent.putExtra(RefuelApplicationConstants.EXTRAS_VEHICLE_ID, vehicles.get(position).getCarId());
                                context.startActivity(refuelingListIntent);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (vehicles != null) {
            return vehicles.size();
        }
        return 0;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = new ArrayList<>(vehicles);
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder {
        private LayoutVehicleItemBinding binding;

        public VehicleViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public LayoutVehicleItemBinding getBinding() {
            return binding;
        }
    }

}
