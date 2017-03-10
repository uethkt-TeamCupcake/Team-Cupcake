package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class ToastUtils {

    public static final String ERROR_MESSAGE = "This's an error message";

    public static void quickToast(Context context, String msg) {
        quickToast(context, msg, false);
    }

    public static void quickToast(Context context, String msg, boolean isLong) {
        Toast toast = null;
        if (isLong) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if (v != null) {
            v.setGravity(Gravity.CENTER);
            v.setPadding(10, 0, 10, 0);
        }
        toast.show();
    }

    public static void showErrorShortToast(Context context) {
        Toast toast = null;
        toast = Toast.makeText(context, ToastUtils.ERROR_MESSAGE, Toast.LENGTH_SHORT);
        toast.show();
    }

}
