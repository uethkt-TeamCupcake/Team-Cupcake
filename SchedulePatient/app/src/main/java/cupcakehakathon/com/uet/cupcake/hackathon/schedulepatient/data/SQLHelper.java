package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NgocThai on 11/03/2017.
 */

public class SQLHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DOCTOR.db";
    public static final int DB_VERSION = 1;


    // table hospital
    public static final String TABLE_NAME_HOSPITAL = "HOSPITAL";
    public static final String HOS_ID = "id";
    public static final String HOS_NAME = "name";
    public static final String HOS_KIND = "kind";
    public static final String HOS_LIMIT = "limited";
    public static final String HOS_ADDRESS = "address";
    public static final String HOS_LATITUDE = "latitude";
    public static final String HOS_LONGITUDE = "longitude";
    public static final String HOS_PHONE = "phone";
    public static final String HOS_IMAGE = "image";
    public static final String HOS_DESCRIPTION = "description";

    // table faculty
    public static final String TABLE_NAME_FACULTY = "FACULTY";
    public static final String FAC_ID = "id";
    public static final String FAC_NAME = "name";
    public static final String FAC_ID_HOSPITAL = "idHospital";
    public static final String FAC_KIND = "kind";
    public static final String FAC_DESCRIPTION = "description";

    // table request
    public static final String TABLE_NAME_REQUEST = "REQUEST";
    public static final String REQ_ID = "id";
    public static final String REQ_ID_PATIENT = "idPatient";
    public static final String REQ_SYMPTOM = "symptom";
    public static final String REQ_TIME = "requestTime";
    public static final String REQ_ID_FACULTY = "idFaculty";
    public static final String REQ_CHECKED = "checked";
    public static final String REQ_DAY_TARGET = "dayTarget";

    // table history
    public static final String TABLE_NAME_HISTORY = "HISTORY";
    public static final String HIS_ID = "id";
    public static final String HIS_SYMPTOM = "symptom";
    public static final String HIS_REQ_TIME = "requestTime";
    public static final String HIS_NAME_FACULTY = "nameFaculty";
    public static final String HIS_DAY_TARGET = "dayTarget";
    public static final String HIS_TIME_START = "appointmentTime";
    public static final String HIS_TIME_END = "appointmentTimeEnd";
    public static final String HIS_DOCTOR_DESC = "doctorDesc";
    public static final String HIS_DOCTOR_NAME = "doctorName";
    public static final String HIS_RESPONSE_DESC = "responseDesc";
    public static final String HIS_ID_REQUEST = "idRequest";
    public static final String HIS_ROOM_NAME = "roomName";
    public static final String HIS_SUCCESS = "success";

    public static final String SQL_CREATE_TABLE_HISTORY = "CREATE TABLE " + TABLE_NAME_HISTORY + " ("
            + HIS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HIS_SYMPTOM + " TEXT, "
            + HIS_REQ_TIME + " TEXT, "
            + HIS_NAME_FACULTY + " INTEGER, "
            + HIS_DAY_TARGET + " TEXT, "
            + HIS_TIME_START + " TEXT, "
            + HIS_TIME_END + " TEXT, "
            + HIS_DOCTOR_DESC + " TEXT, "
            + HIS_DOCTOR_NAME + " TEXT, "
            + HIS_RESPONSE_DESC + " TEXT, "
            + HIS_ID_REQUEST + " INTEGER, "
            + HIS_ROOM_NAME + " TEXT ,"
            + HIS_SUCCESS + " INTEGER "
            + ")";

    public static final String SQL_CREATE_TABLE_REQUEST = "CREATE TABLE " + TABLE_NAME_REQUEST + "("
            + REQ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + REQ_ID_PATIENT + " INTEGER NOT NULL, "
            + REQ_SYMPTOM + " TEXT NOT NULL, "
            + REQ_TIME + " TEXT NOT NULL, "
            + REQ_ID_FACULTY + " INTEGER NOT NULL, "
            + REQ_CHECKED + " INTEGER NOT NULL, "
            + REQ_DAY_TARGET + " TEXT NOT NULL"
            + ")";

    public static final String SQL_CREATE_TABLE_HOSPITAL = "CREATE TABLE " + TABLE_NAME_HOSPITAL + " ("
            + HOS_ID + " INTEGER NOT NULL PRIMARY KEY, "
            + HOS_NAME + " TEXT NOT NULL, "
            + HOS_KIND + " TEXT NOT NULL, "
            + HOS_LIMIT + " TEXT NOT NULL, "
            + HOS_ADDRESS + " TEXT NOT NULL, "
            + HOS_DESCRIPTION + " TEXT NOT NULL, "
            + HOS_LATITUDE + " TEXT NOT NULL, "
            + HOS_LONGITUDE + " TEXT NOT NULL, "
            + HOS_PHONE + " TEXT NOT NULL, "
            + HOS_IMAGE + " TEXT NOT NULL "
            + ")";

    public static final String SQL_CREATE_TABLE_FACULTY = "CREATE TABLE " + TABLE_NAME_FACULTY + " ("
            + FAC_ID + " INTEGER NOT NULL PRIMARY KEY, "
            + FAC_NAME + " TEXT NOT NULL, "
            + FAC_ID_HOSPITAL + " INTEGER NOT NULL, "
            + FAC_DESCRIPTION + " TEXT NOT NULL, "
            + FAC_KIND + " INTEGER NOT NULL "
            + ")";


    public static final String SQL_SELECT_ALL_REQUEST = "SELECT * FROM " + TABLE_NAME_REQUEST;
    public static final String SQL_SELECT_ALL_HOSPITAL = "SELECT * FROM " + TABLE_NAME_HOSPITAL;
    public static final String SQL_SELECT_HOSPITAL_BY_ID = "SELECT * FROM " + TABLE_NAME_HOSPITAL + " WHERE " + HOS_ID + " = ";
    public static final String SQL_SELECT_ALL_FACULTY = "SELECT * FROM " + TABLE_NAME_FACULTY;
    public static final String SQL_SELECT_FACULTY_BY_HOSPITAL = "SELECT * FROM "
            + TABLE_NAME_FACULTY + " WHERE " + FAC_ID_HOSPITAL + " = ";


    public static final String SQL_DROP_TABLE_HOSPITAL = "DROP TABLE IF EXIST " + TABLE_NAME_HOSPITAL;
    public static final String SQL_DROP_TABLE_FACULTY = "DROP TABLE IF EXIST " + TABLE_NAME_FACULTY;
    private static final String SQL_DROP_TABLE_REQUEST = "DROP TABLE IF EXIST " + TABLE_NAME_REQUEST;
    public static final String SQL_DROP_TABLE_HISTORY = "DROP TABLE IF EXIST " + TABLE_NAME_HISTORY;

    public SQLHelper(Context context) {
        super(context, SQLHelper.DB_NAME, null, SQLHelper.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLHelper.SQL_CREATE_TABLE_HOSPITAL);
        db.execSQL(SQLHelper.SQL_CREATE_TABLE_FACULTY);
        db.execSQL(SQLHelper.SQL_CREATE_TABLE_REQUEST);
        db.execSQL(SQLHelper.SQL_CREATE_TABLE_HISTORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE_HOSPITAL);
        db.execSQL(SQL_DROP_TABLE_FACULTY);
        db.execSQL(SQL_DROP_TABLE_REQUEST);
        db.execSQL(SQL_DROP_TABLE_HISTORY);
        onCreate(db);
    }

}