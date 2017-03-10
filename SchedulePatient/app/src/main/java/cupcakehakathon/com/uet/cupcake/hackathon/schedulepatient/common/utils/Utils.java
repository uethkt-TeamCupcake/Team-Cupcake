package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by NgocThai on 10/03/2017.
 */

public class Utils {


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
