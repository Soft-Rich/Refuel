package be.ehb.digx.refuel.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.android.annotations.NonNull;

/**
 * Created by richsoft on 23/11/2016.
 */

public class ProgressDialogFragment extends DialogFragment {

    Context context;

    public void setContext(@NonNull Context context) {
        this.context = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        return dialog;
    }
}
