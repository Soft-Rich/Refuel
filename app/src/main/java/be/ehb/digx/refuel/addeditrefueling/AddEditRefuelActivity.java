package be.ehb.digx.refuel.addeditrefueling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import be.ehb.digx.refuel.R;

public class AddEditRefuelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_refuel);

        AddEditRefuelingFragment addEditRefuelingFragment = new AddEditRefuelingFragment();
        addEditRefuelingFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_vehicles_add_edit_refueling_pane_two, addEditRefuelingFragment)
                .commit();

    }
}
