package be.ehb.digx.refuel.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

/**
 * Created by richsoft on 17/11/2016.
 */

public class DateTimeDialog extends AlertDialog.Builder{

    private static final String TAG = "RefuelingDialog";
    Context context;


    public DateTimeDialog(@NonNull final Context context) {
        super(context);
        this.context = context;

        this.create();
    }


    @Override
    public AlertDialog create() {

        return super.create();

    }

}
