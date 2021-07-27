package assistant.genuinecoder.s_assistant.main.profile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;

public class ProfileAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<String> dates;
    ArrayList<String> datesALONE;
    ArrayList<Integer> hourALONE;
    ArrayList<Boolean> present;
    String uname;

    public ProfileAdapter(ArrayList<String> dates2, ArrayList<Boolean> present2, Activity activity2, ArrayList<String> datesALONE2, ArrayList<Integer> hourALONE2, String re) {
        this.dates = dates2;
        this.present = present2;
        this.activity = activity2;
        this.datesALONE = datesALONE2;
        this.hourALONE = hourALONE2;
        this.uname = re;
    }

    public int getCount() {
        return this.dates.size();
    }

    public Object getItem(int position) {
        return this.dates.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(final int position, View v, ViewGroup parent) {
        if (v == null) {
            v = LayoutInflater.from(this.activity).inflate(C0520R.layout.list_ele, (ViewGroup) null);
        }
        int i = position;
        TextView textView = (TextView) v.findViewById(C0520R.C0522id.attendanceName);
        textView.setText(this.dates.get(position));
        CheckBox checkBox = (CheckBox) v.findViewById(C0520R.C0522id.attMarker);
        checkBox.setClickable(false);
        Log.d("Profile", this.present.get(position) + "");
        checkBox.setChecked(this.present.get(position).booleanValue());
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(ProfileAdapter.this.activity);
                alert.setTitle("Alter Student Attendance");
                alert.setMessage("Are you sure?");
                alert.setPositiveButton("Present", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "UPDATE ATTENDANCE SET ISPRESENT = 1 WHERE  register = '" + ProfileAdapter.this.uname + "' AND datex = '" + ProfileAdapter.this.datesALONE.get(position) + "' AND hour = " + ProfileAdapter.this.hourALONE.get(position);
                        if (AppBase.handler.execAction(qu)) {
                            Toast.makeText(ProfileAdapter.this.activity, "Done", 1).show();
                        }
                        Log.d(Scopes.PROFILE, qu);
                    }
                });
                alert.setNegativeButton("Absent", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "UPDATE ATTENDANCE SET ISPRESENT = 0 WHERE  register = '" + ProfileAdapter.this.uname + "' AND datex = '" + ProfileAdapter.this.datesALONE.get(position) + "' AND hour = " + ProfileAdapter.this.hourALONE.get(position);
                        if (AppBase.handler.execAction(qu)) {
                            Toast.makeText(ProfileAdapter.this.activity, "Done", 1).show();
                        }
                        Log.d(Scopes.PROFILE, qu);
                    }
                });
                alert.show();
                return true;
            }
        });
        return v;
    }
}
