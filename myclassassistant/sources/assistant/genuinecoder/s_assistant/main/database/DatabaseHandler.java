package assistant.genuinecoder.s_assistant.main.database;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHandler {
    Activity activity;
    private SQLiteDatabase database;

    public DatabaseHandler(Activity activity2) {
        this.activity = activity2;
        this.database = activity2.openOrCreateDatabase("ASSIST", 0, (SQLiteDatabase.CursorFactory) null);
        createTable();
    }

    public void createTable() {
        try {
            this.database.execSQL("CREATE TABLE IF NOT EXISTS STUDENT(name varchar(1000),cl varchar(100), regno varchar(100) primary key, contact varchar(100),roll integer);");
        } catch (Exception e) {
            Toast.makeText(this.activity, "Error Occured for create table", 1).show();
        }
        try {
            this.database.execSQL("CREATE TABLE IF NOT EXISTS ATTENDANCE(datex date,hour int, register varchar(100) ,isPresent boolean);");
        } catch (Exception e2) {
            Toast.makeText(this.activity, "Error Occured for create table", 1).show();
        }
        try {
            this.database.execSQL("CREATE TABLE IF NOT EXISTS NOTES(title varchar(100) not null,body varchar(10000), cls varchar(1000), sub varchar(1000) ,datex TIMESTAMP default CURRENT_TIMESTAMP);");
        } catch (Exception e3) {
            Toast.makeText(this.activity, "Error Occured for create table", 1).show();
        }
        try {
            this.database.execSQL("CREATE TABLE IF NOT EXISTS SCHEDULE(cl varchar(100),subject varchar(1000),timex time, day_week varchar(100));");
        } catch (Exception e4) {
            Toast.makeText(this.activity, "Error Occured for create table", 1).show();
        }
    }

    public boolean execAction(String qu) {
        Log.i("DatabaseHandler", qu);
        try {
            this.database.execSQL(qu);
            return true;
        } catch (Exception e) {
            Log.e("DatabaseHandler", qu);
            Toast.makeText(this.activity, "Error Occured for execAction", 1).show();
            return false;
        }
    }

    public Cursor execQuery(String qu) {
        try {
            return this.database.rawQuery(qu, (String[]) null);
        } catch (Exception e) {
            Log.e("DatabaseHandler", qu);
            Toast.makeText(this.activity, "Error Occurred for execAction", 1).show();
            return null;
        }
    }
}
