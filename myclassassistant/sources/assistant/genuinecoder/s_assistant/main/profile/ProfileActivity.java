package assistant.genuinecoder.s_assistant.main.profile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.p003v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import assistant.genuinecoder.s_assistant.main.database.DatabaseHandler;
import com.google.android.gms.common.Scopes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Activity activity = this;
    ProfileAdapter adapter;
    ArrayList<Boolean> atts;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    ArrayList<String> dates;
    ArrayList<String> datesALONE;
    DatabaseHandler handler = AppBase.handler;
    ArrayList<Integer> hourALONE;
    ListView listView;
    Activity profileActivity = this;
    final DatabaseReference table_user = this.database.getReference();

    /* renamed from: v */
    private View f81v;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.stu_profile);
        this.dates = new ArrayList<>();
        this.datesALONE = new ArrayList<>();
        this.hourALONE = new ArrayList<>();
        this.atts = new ArrayList<>();
        this.listView = (ListView) findViewById(C0520R.C0522id.attendProfileView_list);
        ((FloatingActionButton) findViewById(C0520R.C0522id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProfileActivity.this.startActivity(new Intent(ProfileActivity.this.profileActivity, StudentRegistration.class));
            }
        });
        this.table_user.addValueEventListener(new ValueEventListener() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<ProfileActivity> cls = ProfileActivity.class;
            }

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ((TextView) ProfileActivity.this.findViewById(C0520R.C0522id.profileContentView)).setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(ProfileActivity.this.activity);
                        alert.setTitle("Delete Student");
                        alert.setMessage("Are you sure ?");
                        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String regno = ((EditText) ProfileActivity.this.findViewById(C0520R.C0522id.editText)).getText().toString();
                                if (AppBase.handler.execAction("DELETE FROM STUDENT WHERE REGNO = '" + regno.toUpperCase() + "'")) {
                                    Log.d("delete", "done from student");
                                    if (AppBase.handler.execAction("DELETE FROM ATTENDANCE WHERE register = '" + regno.toUpperCase() + "'")) {
                                        Toast.makeText(ProfileActivity.this.getBaseContext(), "Deleted", 1).show();
                                        Log.d("delete", "done from attendance");
                                    }
                                }
                            }
                        });
                        alert.setNegativeButton("No", (DialogInterface.OnClickListener) null);
                        alert.show();
                        return true;
                    }
                });
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        this.table_user.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        ((Button) findViewById(C0520R.C0522id.buttonFind)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileActivity.this.find(v);
            }
        });
    }

    public void find(View view) {
        String attendance;
        this.dates.clear();
        this.atts.clear();
        EditText editText = (EditText) findViewById(C0520R.C0522id.editText);
        TextView textView = (TextView) findViewById(C0520R.C0522id.profileContentView);
        String reg = editText.getText().toString();
        String qu = "SELECT * FROM STUDENT WHERE regno = '" + reg.toUpperCase() + "'";
        String qc = "SELECT * FROM ATTENDANCE WHERE register = '" + reg.toUpperCase() + "';";
        String qd = "SELECT * FROM ATTENDANCE WHERE register = '" + reg.toUpperCase() + "' AND isPresent = 1";
        Cursor cursor = this.handler.execQuery(qu);
        float att = 0.0f;
        Cursor cur = this.handler.execQuery(qc);
        Cursor cur1 = this.handler.execQuery(qd);
        if (cur == null) {
            Log.d(Scopes.PROFILE, "cur null");
        }
        if (cur1 == null) {
            Log.d(Scopes.PROFILE, "cur1 null");
        }
        if (!(cur == null || cur1 == null)) {
            cur.moveToFirst();
            cur1.moveToFirst();
            try {
                float att2 = (((float) cur1.getCount()) / ((float) cur.getCount())) * 100.0f;
                if (att2 <= 0.0f) {
                    att = 0.0f;
                } else {
                    att = att2;
                }
                Log.d("ProfileActivity", "Total = " + cur.getCount() + " avail = " + cur1.getCount() + " per " + att);
            } catch (Exception e) {
                Exception exc = e;
                att = -1.0f;
            }
        }
        if (cursor == null) {
            String str = qu;
            String str2 = qc;
            String str3 = qd;
            Cursor cursor2 = cursor;
            float f = att;
        } else if (cursor.getCount() == 0) {
            String str4 = reg;
            String str5 = qu;
            String str6 = qc;
            String str7 = qd;
            Cursor cursor3 = cursor;
            float f2 = att;
        } else {
            if (att < 0.0f) {
                attendance = "Attendance Not Available";
            } else {
                attendance = " Attendance " + att + " %";
            }
            cursor.moveToFirst();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(" ");
            String str8 = reg;
            sb.append(cursor.getString(0));
            sb.append("\n");
            String buffer = ((((sb.toString() + " " + cursor.getString(1) + "\n") + " " + cursor.getString(2) + "\n") + " " + cursor.getString(3) + "\n") + " " + cursor.getInt(4) + "\n") + " " + attendance + "\n";
            textView.setText(buffer);
            Cursor cursorx = this.handler.execQuery("SELECT * FROM ATTENDANCE WHERE register = '" + editText.getText().toString().toUpperCase() + "'");
            if (cursorx == null) {
                String str9 = buffer;
                String str10 = qu;
                String str11 = qc;
                String str12 = qd;
                Cursor cursor4 = cursor;
                float f3 = att;
            } else if (cursorx.getCount() == 0) {
                String str13 = buffer;
                String str14 = qu;
                String str15 = qc;
                String str16 = qd;
                Cursor cursor5 = cursor;
                float f4 = att;
            } else {
                cursorx.moveToFirst();
                while (!cursorx.isAfterLast()) {
                    String buffer2 = buffer;
                    String qu2 = qu;
                    this.datesALONE.add(cursorx.getString(0));
                    this.hourALONE.add(Integer.valueOf(cursorx.getInt(1)));
                    ArrayList<String> arrayList = this.dates;
                    StringBuilder sb2 = new StringBuilder();
                    String qc2 = qc;
                    sb2.append(cursorx.getString(0));
                    sb2.append(":");
                    sb2.append(cursorx.getInt(1));
                    sb2.append("th Hour");
                    arrayList.add(sb2.toString());
                    if (cursorx.getInt(3) == 1) {
                        this.atts.add(true);
                    } else {
                        Log.d(Scopes.PROFILE, cursorx.getString(0) + " -> " + cursorx.getInt(3));
                        this.atts.add(false);
                    }
                    cursorx.moveToNext();
                    buffer = buffer2;
                    qu = qu2;
                    qc = qc2;
                }
                String str17 = qu;
                String str18 = qc;
                String str19 = qd;
                Cursor cursor6 = cursor;
                float f5 = att;
                this.adapter = new ProfileAdapter(this.dates, this.atts, this.profileActivity, this.datesALONE, this.hourALONE, editText.getText().toString().toUpperCase());
                this.listView.setAdapter(this.adapter);
                return;
            }
            Toast.makeText(getBaseContext(), "No Attendance Info Available", 1).show();
            return;
        }
        textView.setText("No Data Available");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(C0520R.C0524menu.profile_menu, menu);
        return true;
    }

    public void editStudent(MenuItem item) {
        startActivity(new Intent(this, Main5Activity.class));
    }
}
