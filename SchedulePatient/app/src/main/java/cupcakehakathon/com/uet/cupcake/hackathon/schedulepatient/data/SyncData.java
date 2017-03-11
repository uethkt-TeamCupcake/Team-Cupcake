package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.data;

import java.util.ArrayList;

import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.FacultyObject;
import cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.object.HospitalObject;

/**
 * Created by NgocThai on 11/03/2017.
 */

public class SyncData {

//    public static boolean checkHospitalChange(ArrayList<HospitalObject> lsLocal, ArrayList<HospitalObject> lsServer) {
//        if (lsLocal.size() == 0) {
//            return true;
//        } else if (lsLocal.size() != lsServer.size()) {
//            return true;
//        }
//        return false;
//    }

    public static boolean checkFacultyChange(ArrayList<FacultyObject> lsLocal, ArrayList<FacultyObject> lsServer) {
        if (lsLocal.size() == 0) {
            return true;
        } else if (lsLocal.size() != lsServer.size()) {
            return true;
        }
        return false;
    }

}
