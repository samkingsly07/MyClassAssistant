package assistant.genuinecoder.s_assistant.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.components.About;
import assistant.genuinecoder.s_assistant.main.components.GridAdapter;
import assistant.genuinecoder.s_assistant.main.components.SettingsActivity;
import assistant.genuinecoder.s_assistant.main.components.pro;
import assistant.genuinecoder.s_assistant.main.database.DatabaseHandler;
import assistant.genuinecoder.s_assistant.main.profile.Main2Activity;
import java.util.ArrayList;

public class AppBase extends AppCompatActivity {
    public static Activity activity;
    public static ArrayList<String> divisions;
    public static DatabaseHandler handler;
    GridAdapter adapter;
    ArrayList<String> basicFields;
    GridView gridView;
    SharedPreferences prf;

    public void onBackPressed() {
        backButtonHandler();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(C0520R.C0524menu.mai_menu, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.base_layout);
        this.prf = getSharedPreferences("user_details", 0);
        ((TextView) findViewById(C0520R.C0522id.textView2)).setText("HELLO ");
        ((TextView) findViewById(C0520R.C0522id.textView3)).setText("" + this.prf.getString("username", (String) null));
        this.basicFields = new ArrayList<>();
        handler = new DatabaseHandler(this);
        activity = this;
        getSupportActionBar().show();
        divisions = new ArrayList<>();
        divisions.add("S1 COMPUTER SCIENCE");
        divisions.add("S2 COMPUTER SCIENCE");
        divisions.add("S3 COMPUTER SCIENCE");
        divisions.add("S4 COMPUTER SCIENCE");
        divisions.add("S5 COMPUTER SCIENCE");
        divisions.add("S6 COMPUTER SCIENCE");
        divisions.add("S7 COMPUTER SCIENCE");
        this.gridView = (GridView) findViewById(C0520R.C0522id.grid);
        this.basicFields.add("ATTENDANCE");
        this.basicFields.add("SCHEDULER");
        this.basicFields.add("NOTES");
        this.basicFields.add("PROFILE");
        this.basicFields.add("CGPA CALCULATOR");
        this.adapter = new GridAdapter(this, this.basicFields);
        this.gridView.setAdapter(this.adapter);
    }

    public void loadSettings(MenuItem item) {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    public void loadAbout(MenuItem item) {
        startActivity(new Intent(this, About.class));
    }

    public void loadpro(MenuItem item) {
        startActivity(new Intent(this, pro.class));
    }

    public void loadss(MenuItem item) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Leave application?");
        alertDialog.setMessage("Are you sure you want to leave the application?");
        alertDialog.setIcon(C0520R.C0521drawable.ic_sync_black_24dp);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                AppBase.this.finishAffinity();
                System.exit(0);
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
}
