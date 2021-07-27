package assistant.genuinecoder.s_assistant.main.attendance;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import assistant.genuinecoder.s_assistant.main.components.ListAdapter;
import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String period;
    public static String time;
    ListAdapter adapter;
    ArrayAdapter<String> adapterSpinner;
    ListView listView;
    ArrayList<String> names;
    ArrayList<String> registers;
    Spinner spinner;
    Activity thisActivity = this;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_attendance);
        time = getIntent().getStringExtra("DATE");
        period = getIntent().getStringExtra("PERIOD");
        Log.d("Attendance", time + " -- " + period);
        this.listView = (ListView) findViewById(C0520R.C0522id.attendanceListViwe);
        this.names = new ArrayList<>();
        this.registers = new ArrayList<>();
        ((Button) findViewById(C0520R.C0522id.loadButton)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttendanceActivity.this.loadListView(v);
            }
        });
        ((Button) findViewById(C0520R.C0522id.buttonSaveAttendance)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AttendanceActivity.this.getBaseContext(), "Saving", 1).show();
                AttendanceActivity.this.adapter.saveAll();
            }
        });
        this.spinner = (Spinner) findViewById(C0520R.C0522id.attendanceSpinner);
        this.adapterSpinner = new ArrayAdapter<>(this, 17367049, AppBase.divisions);
        this.spinner.setAdapter(this.adapterSpinner);
    }

    public void loadListView(View view) {
        this.names.clear();
        this.registers.clear();
        Cursor cursor = AppBase.handler.execQuery("SELECT * FROM STUDENT WHERE cl = '" + this.spinner.getSelectedItem().toString() + "' ORDER BY ROLL");
        if (cursor == null || cursor.getCount() == 0) {
            Log.e("Attendance", "Null cursor");
        } else {
            int ctr = 0;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ArrayList<String> arrayList = this.names;
                arrayList.add(cursor.getString(0) + " (" + cursor.getInt(4) + ')');
                this.registers.add(cursor.getString(2));
                cursor.moveToNext();
                ctr++;
            }
            if (ctr == 0) {
                Toast.makeText(getBaseContext(), "No Students Found", 1).show();
            }
            Log.d("Attendance", "Got " + ctr + " students");
        }
        this.adapter = new ListAdapter(this.thisActivity, this.names, this.registers);
        this.listView.setAdapter(this.adapter);
    }
}
