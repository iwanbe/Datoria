package ch.bbcag.datoria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by bhaenl on 02.05.2017.
 */

public final class DatabaseContract {

    private DatabaseContract(){};

    public static class DebtEntry implements BaseColumns{
        public static final String TABLE_NAME = "debt";
        public static final String COLUMN_NAME_AMOUNT = "amount";
        //public static final String COLUMN_NAME_NOTE = "note";
        //public static final String COLUMN_NAME_REMINDER = "reminder";
        public static final String COLUMN_NAME_DEBTOWNERID = "debtowner_id";
    }

    public static class DebtOwnerEntry implements BaseColumns{
        public static final String TABLE_NAME = "debtowner";
        public static final String COLUMN_NAME_LASTNAME = "firstname";
        public static final String COLUMN_NAME_FIRSTNAME = "lastname";
        public static final String COLUMN_NAME_TEL = "tel";
    }

    private static final String SQL_CREATE_DEBTOWNER_ENTIRES =
            "CREATE TABLE " + DebtOwnerEntry.TABLE_NAME + " (" +
                    DebtOwnerEntry._ID + " INTEGER PRIMARY KEY," +
                    DebtOwnerEntry.COLUMN_NAME_FIRSTNAME + " TEXT," +
                    DebtOwnerEntry.COLUMN_NAME_LASTNAME + " TEXT," +
                    DebtOwnerEntry.COLUMN_NAME_TEL + " TEXT)";

    private static final String SQL_DELETE_DEBTOWNER_ENTRIES =
            "DROP TABLE IF EXISTS "+ DebtOwnerEntry.TABLE_NAME;

    private static final String SQL_CREATE_DEBT_ENTRIES =
            "CREATE TABLE " + DebtEntry.TABLE_NAME + " (" +
                    DebtEntry._ID + " INTEGER PRIMARY KEY," +
                    DebtEntry.COLUMN_NAME_AMOUNT + " REAL," +
                    DebtEntry.COLUMN_NAME_DEBTOWNERID + " INTEGER," +
                    "FOREIGN KEY " + "(" + DebtEntry.COLUMN_NAME_DEBTOWNERID + ") REFERENCES "
                    + DebtOwnerEntry.TABLE_NAME + " (" + DebtOwnerEntry._ID + "))";

    private static final String SQL_DELETE_DEBT_ENTRIES =
            "DROP TABLE IF EXISTS " + DebtEntry.TABLE_NAME;

    public static class DatabaseHelper extends SQLiteOpenHelper {

        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Datoria.db";

        public DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db){
            db.execSQL(SQL_CREATE_DEBTOWNER_ENTIRES);
            db.execSQL(SQL_CREATE_DEBT_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL(SQL_DELETE_DEBTOWNER_ENTRIES);
            db.execSQL(SQL_DELETE_DEBT_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
            onUpgrade(db, oldVersion, newVersion);
        }

    }

}
