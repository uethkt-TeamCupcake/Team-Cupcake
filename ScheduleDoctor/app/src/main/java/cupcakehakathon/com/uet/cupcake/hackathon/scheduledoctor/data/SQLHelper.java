package cupcakehakathon.com.uet.cupcake.hackathon.scheduledoctor.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Luong Tran on 3/10/2017.
 */

public class SQLHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DOCTOR.db";
    public static final int DB_VERSION = 1;

    //table request of patient
    public static final String TABLE_NAME_REQUEST = "REQUEST";
    public static final String REQ_ID = "ID";
    public static final String REQ_SYMPTOM = "SYMPTOM";
    public static final String REQ_TIME = "TIME";
    public static final String REQ_NAME = "NAME";
    public static final String REQ_BIRTHDAY = "BIRTHDAY";
    public static final String REQ_GENDER = "GENDER";
    public static final String REQ_IDENTITY = "IDENTITY";
    public static final String REQ_INSURANCE = "INSURANCE";
    public static final String REQ_ADDRESS = "ADDRESS";
    public static final String REQ_DAY_TARGET = "TARGET";

    // table room
    public static final String TABLE_NAME_ROOM = "ROOM";
    public static final String ROOM_ID = "id";
    public static final String ROOM_NAME = "name";
    public static final String ROOM_DESCRIPTION = "description";
    public static final String ROOM_LIMIT_ONE_DAY = "limitOneDay";
    public static final String ROOM_TIME_START = "timeStart";
    public static final String ROOM_TIME_END = "timeEnd";
    public static final String ROOM_CURRENT_LIMIT = "currentLimit";
    public static final String ROOM_TIME_AVAILABLE = "timeAvailable";
    public static final String ROOM_TIME_SIZE = "timeSize";

    private static final String SQL_CREATE_TABLE_ROOM = "CREATE TABLE " + TABLE_NAME_ROOM + " ("
        + ROOM_ID + " INTEGER PRIMARY KEY, "
        + ROOM_NAME + " TEXT NOT NULL, "
        + ROOM_DESCRIPTION + " TEXT NOT NULL, "
        + ROOM_LIMIT_ONE_DAY + " INTEGER NOT NULL, "
        + ROOM_TIME_START + " DATETIME DEFAULT CURRENT_TIME , "
        + ROOM_TIME_END + " DATETIME DEFAULT CURRENT_TIME , "
        + ROOM_CURRENT_LIMIT + " INTEGER NOT NULL, "
        + ROOM_TIME_AVAILABLE + " DATETIME DEFAULT CURRENT_TIME, "
        + ROOM_TIME_SIZE + " INTEGER NOT NULL "
        + ")";

    private static final String SQL_CREATE_TABLE_REQUEST = "CREATE TABLE " + TABLE_NAME_REQUEST + " ("
        + REQ_ID + " INTEGER PRIMARY KEY, "
        + REQ_SYMPTOM + " TEXT NOT NULL, "
        + REQ_TIME + " DATETIME NOT NULL, "
        + REQ_NAME + " TEXT NOT NULL, "
        + REQ_BIRTHDAY + " DATE NOT NULL, "
        + REQ_GENDER + " TEXT NOT NULL, "
        + REQ_IDENTITY + " TEXT NOT NULL, "
        + REQ_INSURANCE + " TEXT NOT NULL, "
        + REQ_ADDRESS + " TEXT NOT NULL, "
        + REQ_DAY_TARGET + " DATE NOT NULL"
        + ")";


    public static final String SQL_QUERY_ALL_REQUEST = "SELECT * FROM " + TABLE_NAME_REQUEST;
    public static final String SQL_QUERY_ALL_ROOM = "SELECT * FROM " + TABLE_NAME_ROOM;

    private static final String SQL_DROP_TABLE_ROOM = "DROP_TABLE IF EXIST " + TABLE_NAME_ROOM;
    private static final String SQL_DROP_TABLE_REQUEST = "DROP TABLE IF EXIST " + TABLE_NAME_REQUEST;

    public SQLHelper(Context context) {
        super(context, SQLHelper.DB_NAME, null, SQLHelper.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_REQUEST);
        db.execSQL(SQL_CREATE_TABLE_ROOM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE_REQUEST);
        db.execSQL(SQL_DROP_TABLE_ROOM);
        onCreate(db);
    }
}
