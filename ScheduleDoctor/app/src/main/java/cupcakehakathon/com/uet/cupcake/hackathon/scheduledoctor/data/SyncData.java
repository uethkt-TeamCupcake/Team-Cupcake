package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.data;

import java.util.ArrayList;

import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RequestObject;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RoomObject;

/**
 * Created by NgocThai on 11/03/2017.
 */

public class SyncData {

    public static boolean checkRequestChange(ArrayList<RequestObject> lsLocal, ArrayList<RequestObject> lsServer) {
        if (lsLocal.size() == 0) {
            return true;
        } else if (lsLocal.size() != lsServer.size()) {
            return true;
        }
        return false;
    }

    public static boolean checkRoomChange(ArrayList<RoomObject> lsLocal, ArrayList<RoomObject> lsServer) {
        if (lsLocal.size() == 0) {
            return true;
        } else if (lsLocal.size() != lsServer.size()) {
            return true;
        }
        return false;
    }

}
