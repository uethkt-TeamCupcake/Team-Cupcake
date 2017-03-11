package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

import java.util.Calendar;

/**
 * Created by NgocThai on 10/03/2017.
 */

public class Utils {
    public static final String VALUES_TIME = "TIME";
    public static final String VALUES_DATE = "DATE";


    public static boolean checkNetwork(Context context) {
        boolean available = false;
        ConnectivityManager cn = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cn.getActiveNetworkInfo();
        if (info != null && info.isAvailable() && info.isConnected()) {
            available = true;
        }
        return available;
    }


    public static String getCurrentTime(String dateOrTime) {
        Calendar cal = Calendar.getInstance();
        if (dateOrTime.equalsIgnoreCase(VALUES_TIME)) {
            return cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
        } else if (dateOrTime.equalsIgnoreCase(VALUES_DATE)) {
            return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
        }
        return "";
    }

    public static void setValueToPreferences(String key, String values, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, values);
        editor.commit();
    }

    public static String getValueFromPreferences(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

}
