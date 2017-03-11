package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.R;
import java.util.Calendar;

/**
 * Created by Luong Tran on 3/11/2017.
 */

public class DialogUtils {
    public static void dialogShowDate(Activity activity, String title, DatePickerDialog.OnDateSetListener dateChangedListener) {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
            dateChangedListener,
            now.get(Calendar.YEAR),
            now.get(Calendar.MONTH),
            now.get(Calendar.DAY_OF_MONTH)
        );
        //        dpd.showYearPickerFirst(true);
        dpd.dismissOnPause(true);
        //        dpd.setThemeDark(true);
        dpd.vibrate(true);
        dpd.setTitle(title);
        dpd.setAccentColor(Color.parseColor("#4CAF50"));
        dpd.show(activity.getFragmentManager(), "Datepickerdialog");
    }

    public static void showDialog(Context context,
                                  String title,
                                  String message,
                                  String positive,
                                  String negative,
                                  DialogInterface.OnClickListener clickPositive,
                                  DialogInterface.OnClickListener clickNegative) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyDialogTheme);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positive, clickPositive);
        builder.setNegativeButton(negative, clickNegative);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
    }

    public static void showDialog(Context context,
                                  String title,
                                  String msg,
                                  String positive,
                                  DialogInterface.OnClickListener dialogPositive) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyDialogTheme);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(positive, dialogPositive);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
    }

}
