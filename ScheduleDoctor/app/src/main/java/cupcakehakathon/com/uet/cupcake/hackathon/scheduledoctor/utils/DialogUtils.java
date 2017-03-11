package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.utils;

import android.app.Activity;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;

import java.util.Calendar;

/**
 * Created by Dat UET on 3/11/2017.
 */

public class DialogUtils {

    public void dialogShowTime(Activity activity, String title, TimePickerDialog.OnTimeSetListener timeSetListener) {
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(timeSetListener,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                true);

        tpd.enableMinutes(true);
        tpd.vibrate(true);
        tpd.enableMinutes(true);
        tpd.setAccentColor(Color.parseColor("#4CAF50"));
        tpd.setTitle(title);
        tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        tpd.show(activity.getFragmentManager(), "Timepickerdialog");
    }

    // cach dung vua date vua time
//    du.dialogShowDate(AddScheduleActivity.this, "Choose Date", new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
//            date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
//            Toast.makeText(AddScheduleActivity.this, "date : " + date, Toast.LENGTH_SHORT).show();
//            du.dialogShowTime(AddScheduleActivity.this, "Choose Time", new TimePickerDialog.OnTimeSetListener() {
//                @Override
//                public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
//                    String hourString = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
//                    String minuteString = minute < 10 ? "0" + minute : "" + minute;
//                    String secondString = second < 10 ? "0" + second : "" + second;
//
//                    time = hourString + ":" + minuteString + ":" + secondString;
//                    Toast.makeText(AddScheduleActivity.this, "time : " + time, Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    });

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

    // cach dung
//     DialogUtils.dialogShowDate(SendRequestActivity.this, "Choose time", new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
//            targetTime = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
//        }
//    });


}

