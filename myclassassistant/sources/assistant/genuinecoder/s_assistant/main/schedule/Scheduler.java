package assistant.genuinecoder.s_assistant.main.schedule;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.p003v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import java.util.ArrayList;

public class Scheduler extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Activity activity = this;
    ArrayAdapter adapter;
    ListView listView;
    ArrayList<String> subs;
    ArrayList<String> subx;
    ArrayList<String> times;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_scheduler);
        ((FloatingActionButton) findViewById(C0520R.C0522id.fab_sch)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Scheduler.this.startActivity(new Intent(Scheduler.this.getBaseContext(), CreateScheduleActivity.class));
            }
        });
        this.subs = new ArrayList<>();
        this.times = new ArrayList<>();
        this.subx = new ArrayList<>();
        this.listView = (ListView) findViewById(C0520R.C0522id.schedulerList);
        loadSchedules();
        this.listView.setOnItemLongClickListener(this);
    }

    /* access modifiers changed from: private */
    public void loadSchedules() {
        this.subs.clear();
        this.times.clear();
        Cursor cursor = AppBase.handler.execQuery("SELECT * FROM SCHEDULE ORDER BY subject");
        if (cursor == null || cursor.getCount() == 0) {
            Toast.makeText(getBaseContext(), "No Schedules Available", 1).show();
        } else {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                this.subx.add(cursor.getString(1));
                ArrayList<String> arrayList = this.subs;
                arrayList.add(cursor.getString(1) + "\nfor " + cursor.getString(0) + "\nat " + cursor.getString(2) + " : " + cursor.getString(3));
                this.times.add(cursor.getString(2));
                cursor.moveToNext();
            }
        }
        this.listView.setAdapter(new ArrayAdapter(getBaseContext(), 17367043, this.subs));
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this.activity);
        alert.setTitle("Delete Schedule?");
        alert.setMessage("Do you want to delete this schedule ?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (AppBase.handler.execAction("DELETE FROM SCHEDULE WHERE subject = '" + Scheduler.this.subx.get(position) + "' AND timex = '" + Scheduler.this.times.get(position) + "'")) {
                    Toast.makeText(Scheduler.this.getBaseContext(), "Deleted", 1).show();
                    Scheduler.this.loadSchedules();
                } else {
                    Toast.makeText(Scheduler.this.getBaseContext(), "Failed", 1).show();
                    Scheduler.this.loadSchedules();
                }
                dialog.dismiss();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
        return true;
    }

    public void refresh(MenuItem item) {
        loadSchedules();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(C0520R.C0524menu.scheduler_menu, menu);
        return true;
    }
}
