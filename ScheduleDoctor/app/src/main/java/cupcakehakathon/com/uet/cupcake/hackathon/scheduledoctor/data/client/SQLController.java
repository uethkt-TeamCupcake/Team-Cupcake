package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.data.client;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RequestObject;
import cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.common.object.RoomObject;
import java.util.ArrayList;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class SQLController  {

    private SQLHelper sqlHelper;

    public SQLController(Context context) {
        sqlHelper = new SQLHelper(context);
    }

    public boolean insertRequest(RequestObject requestObject) {
        boolean result = false;
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        try {
            ContentValues vl = new ContentValues();
            vl.put(SQLHelper.REQ_ID, requestObject.getId());
            vl.put(SQLHelper.REQ_SYMPTOM, requestObject.getSymptom());
            vl.put(SQLHelper.REQ_TIME, requestObject.getRequestTime());
            vl.put(SQLHelper.REQ_NAME, requestObject.getName());
            vl.put(SQLHelper.REQ_BIRTHDAY, requestObject.getBirthday());
            vl.put(SQLHelper.REQ_GENDER, requestObject.getGender());
            vl.put(SQLHelper.REQ_IDENTITY, requestObject.getIdentityNumber());
            vl.put(SQLHelper.REQ_INSURANCE, requestObject.getInsuranceCode());
            vl.put(SQLHelper.REQ_ADDRESS, requestObject.getAddress());
            vl.put(SQLHelper.REQ_DAY_TARGET, requestObject.getDayTarget());
            long kq = db.insert(SQLHelper.TABLE_NAME_REQUEST, null, vl);
            if (kq > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return result;
    }

    public boolean insertRoom(RoomObject roomObject) {
        boolean result = false;
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        try {
            ContentValues vl = new ContentValues();
            vl.put(SQLHelper.ROOM_ID, roomObject.getId());
            vl.put(SQLHelper.ROOM_NAME, roomObject.getName());
            vl.put(SQLHelper.ROOM_DESCRIPTION, roomObject.getDescription());
            vl.put(SQLHelper.ROOM_LIMIT_ONE_DAY, roomObject.getLimitOneDay());
            vl.put(SQLHelper.ROOM_TIME_START, roomObject.getTimeStart());
            vl.put(SQLHelper.ROOM_TIME_END, roomObject.getTimeEnd());
            vl.put(SQLHelper.ROOM_CURRENT_LIMIT, roomObject.getCurrentLimit());
            vl.put(SQLHelper.ROOM_TIME_AVAILABLE, roomObject.getTimeAvailable());
            vl.put(SQLHelper.ROOM_TIME_SIZE, roomObject.getTimeSize());
            long kq = db.insert(SQLHelper.TABLE_NAME_ROOM, null, vl);
            if (kq > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return result;
    }

    public ArrayList<RequestObject> queryListRequest(String sql) {
        ArrayList<RequestObject> ls = new ArrayList<>();
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        try {
            Cursor cs = db.rawQuery(sql, null);
            while (cs.moveToNext()) {
                ls.add(new RequestObject(cs.getInt(0), cs.getString(1), cs.getString(2), cs.getString(3), cs.getString(4),
                                         cs.getString(5), cs.getString(6), cs.getString(7), cs.getString(8), cs.getString(9)));
            }
            cs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return ls;
    }

    public ArrayList<RoomObject> queryListRoom(String sql) {
        ArrayList<RoomObject> ls = new ArrayList<>();
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        try {
            Cursor cs = db.rawQuery(sql, null);
            while (cs.moveToNext()) {
                ls.add(new RoomObject(cs.getInt(0), cs.getString(1), cs.getString(2), cs.getInt(3),
                                      cs.getString(4), cs.getString(5), cs.getInt(6), cs.getString(7), cs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return ls;
    }


    public boolean deleteAllData(String table) {
        boolean result = false;
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        try {
            long kq = db.delete(table, null, null);
            if (kq > -1) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return result;
    }

}
