package be.ehb.digx.refuel.vehicles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import be.ehb.digx.refuel.R;

public class VehiclesActivity extends AppCompatActivity {

    private boolean twoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        if (findViewById(R.id.fragment_vehicles_add_edit_refueling_pane_two) != null){
            twoPane = true;
        }
    }

    public boolean isTwoPane() {
        return twoPane;
    }
}
