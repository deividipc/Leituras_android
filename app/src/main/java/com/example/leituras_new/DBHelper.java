package com.example.leituras_new;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.provider.ContactsContract;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;




public class DBHelper {
    private static final String DATABASE_NAME = "quinze.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "maquina";
    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insertstnt;
    private static final String INSERT = "insert into " + TABLE_NAME + " (et_370e,et_370s,et_372e,et_372s,et_377e,et_377s,et_378e,et_378s,et_385e,et_385s,et_461e,et_461s,et_489e,et_489s,et_490e,et_490s) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public DBHelper(Context context) {
        this.context = context;
        OpenHelper openHelper = new OpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertstnt = this.db.compileStatement(INSERT);
    }

    public long insert(String et_370e, String et_370s, String et_372e, String et_372s, String et_377e, String et_377s, String et_378e, String et_378s, String et_385e, String et_385s, String et_461e, String et_461s, String et_489e, String et_489s, String et_490e, String et_490s)
    {
        this.insertstnt.bindString(1, et_370e);
        this.insertstnt.bindString(2, et_370s);
        this.insertstnt.bindString(3, et_372e);
        this.insertstnt.bindString(4, et_372s);
        this.insertstnt.bindString(5, et_377e);
        this.insertstnt.bindString(6, et_377s);
        this.insertstnt.bindString(7, et_378e);
        this.insertstnt.bindString(8, et_378s);
        this.insertstnt.bindString(9, et_385e);
        this.insertstnt.bindString(10, et_385s);
        this.insertstnt.bindString(11, et_461e);
        this.insertstnt.bindString(12, et_461s);
        this.insertstnt.bindString(13, et_489e);
        this.insertstnt.bindString(14, et_489s);
        this.insertstnt.bindString(15, et_490e);
        this.insertstnt.bindString(16, et_490s);
        return this.insertstnt.executeInsert();
    }

    public void deleteAll() {
        this.db.delete(TABLE_NAME, null, null);
    }

    public List<Maquinas> queryGetAll() {
        List<Maquinas> list = new ArrayList<Maquinas>();
        try {
            Cursor cursor = this.db.query (TABLE_NAME, new String[] {"et_370e","et_370s","et_372e","et_372s","et_377e","et_377s","et_378e","et_378s","et_385e","et_385s","et_461e","et_461s","et_489e","et_489s","et_490e","et_490s"},
                    null, null, null, null, null);
            int nregistros = cursor.getCount();
            if (nregistros != 0) {
                cursor.moveToFirst();
                do {
                    Maquinas maquina = new Maquinas (cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15));
                    list.add(maquina);
                } while (cursor.moveToNext());
                if (cursor != null && ! cursor.isClosed())
                    cursor.close();
                return list;
            }else
                return null;
        }
        catch (Exception err) {
            return null;
        }
        //return list;
    }
    private static class OpenHelper extends SQLiteOpenHelper {
        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +" (id INTEGER PRIMARY KEY AUTOINCREMENT,et_370e TEXT,et_370s TEXT,et_372e TEXT,et_372s TEXT,et_377e TEXT,et_377s TEXT,et_378e TEXT, et_378s TEXT,et_385e TEXT,et_385s TEXT,et_461e TEXT,et_461s TEXT, et_489e TEXT,et_489s TEXT,et_490e TEXT,et_490s TEXT );";
            db.execSQL(sql);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}



