package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.map;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.maps.model.LatLng;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.Util.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Luong Tran on 3/11/2017.
 */

public class MapUtils {

    public static boolean checkLocationPermission(Activity context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                                                                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(context,
                                                  new String[] {
                                                      Manifest.permission.ACCESS_FINE_LOCATION
                                                  },
                                                  Constants.MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(context,
                                                  new String[] {
                                                      Manifest.permission.ACCESS_FINE_LOCATION
                                                  },
                                                  Constants.MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    public static String getUrlDistance(LatLng origin, LatLng dest) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Sensor enabled
        String sensor = "sensor=false";
        // Language choose
        String languge = "language=vi";
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor + "&" + languge;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;
        return url;
    }

    /**
     * Download from url
     *
     * @throws IOException
     */
    public static String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);
            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();
            // Connecting to url
            urlConnection.connect();
            // Reading data from url
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    public static class DataParser {

        /**
         * Get distance between two points
         *
         * @throws JSONException
         */
        public static String getDistance(String jsonMaps) throws JSONException {
            final JSONObject json = new JSONObject(jsonMaps);
            JSONArray routeArray = json.getJSONArray("routes");
            JSONObject routes = routeArray.getJSONObject(0);
            JSONArray newTempARr = routes.getJSONArray("legs");
            JSONObject newDisTimeOb = newTempARr.getJSONObject(0);
            JSONObject distOb = newDisTimeOb.getJSONObject("distance");
            return distOb.getString("text");
        }

        /**
         * Get time between two points
         *
         * @throws JSONException
         */
        public static String getTime(String jsonMaps) throws JSONException {
            final JSONObject json = new JSONObject(jsonMaps);
            JSONArray routeArray = json.getJSONArray("routes");
            JSONObject routes = routeArray.getJSONObject(0);
            JSONArray newTempARr = routes.getJSONArray("legs");
            JSONObject newDisTimeOb = newTempARr.getJSONObject(0);
            JSONObject timeOb = newDisTimeOb.getJSONObject("duration");
            return timeOb.getString("text");
        }

        /**
         * Get list instructions from google map api
         *
         * @param jsonMaps
         * @return
         */
        //        public static ArrayList<InstructionObject> getAllInstruction(String jsonMaps) {
        //            ArrayList<InstructionObject> ls = new ArrayList<>();
        //            JSONArray jRoutes;
        //            JSONArray jLegs;
        //            JSONArray jSteps;
        //            try {
        //                JSONObject jsonObject = new JSONObject(jsonMaps);
        //                jRoutes = jsonObject.getJSONArray("routes");
        //                for (int i = 0; i < jRoutes.length(); i++) {
        //                    JSONObject jRoute = (JSONObject) jRoutes.get(i);
        //                    jLegs = jRoute.getJSONArray("legs");
        //                    for (int j = 0; j < jLegs.length(); j++) {
        //                        JSONObject jLeg = (JSONObject) jLegs.get(j);
        //                        jSteps = jLeg.getJSONArray("steps");
        //                        for (int k = 0; k < jSteps.length(); k++) {
        //                            JSONObject jStep = (JSONObject) jSteps.get(k);
        //                            String distance = ((JSONObject) jStep.get("distance")).getString("text");
        //                            String duration = ((JSONObject) jStep.get("duration")).getString("text");
        //                            Spanned spanned = Html.fromHtml(jStep.getString("html_instructions"));
        //                            char[] chars = new char[spanned.length()];
        //                            TextUtils.getChars(spanned, 0, spanned.length(), chars, 0);
        //                            String plainText = new String(chars);
        //                            ls.add(new InstructionObject(plainText, distance, duration));
        ////                            ls.add(new InstructionObject(jStep.getString("html_instructions"), distance, duration));
        //                        }
        //                    }
        //                }
        //
        //            } catch (JSONException e) {
        //                e.printStackTrace();
        //            }
        //            return ls;
        //        }

        /**
         * Receives a JSONObject and returns a list of lists containing latitude and longitude
         */
        public static List<List<HashMap<String, String>>> parse(JSONObject jObject) {
            List<List<HashMap<String, String>>> routes = new ArrayList<>();
            JSONArray jRoutes;
            JSONArray jLegs;
            JSONArray jSteps;
            try {
                jRoutes = jObject.getJSONArray("routes");
                /** Traversing all routes */
                for (int i = 0; i < jRoutes.length(); i++) {
                    jLegs = ((JSONObject) jRoutes.get(i)).getJSONArray("legs");
                    List path = new ArrayList<>();
                    /** Traversing all legs */
                    for (int j = 0; j < jLegs.length(); j++) {
                        jSteps = ((JSONObject) jLegs.get(j)).getJSONArray("steps");
                        /** Traversing all steps */
                        for (int k = 0; k < jSteps.length(); k++) {
                            String polyline = "";
                            polyline =
                                (String) ((JSONObject) ((JSONObject) jSteps.get(k)).get("polyline"))
                                    .get("points");
                            List<LatLng> list = decodePoly(polyline);
                            /** Traversing all points */
                            for (int l = 0; l < list.size(); l++) {
                                HashMap<String, String> hm = new HashMap<>();
                                hm.put("lat", Double.toString((list.get(l)).latitude));
                                hm.put("lng", Double.toString((list.get(l)).longitude));
                                path.add(hm);
                            }
                        }
                        routes.add(path);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
            }
            return routes;
        }

        /**
         * Method to decode polyline points
         * Courtesy : http://jeffreysambells.com/2010/05/27/decoding-polylines-from-google-maps-direction-api-with-java
         */
        public static List<LatLng> decodePoly(String encoded) {

            List<LatLng> poly = new ArrayList<>();
            int index = 0, len = encoded.length();
            int lat = 0, lng = 0;

            while (index < len) {
                int b, shift = 0, result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;

                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;

                LatLng p = new LatLng((((double) lat / 1E5)), (((double) lng / 1E5)));
                poly.add(p);
            }
            return poly;
        }
    }
}
