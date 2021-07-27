package assistant.genuinecoder.s_assistant.main.components;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import assistant.genuinecoder.s_assistant.main.attendance.AttendanceActivity;
import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<Boolean> attendanceList = new ArrayList<>();
    ArrayList<String> nameList;
    ArrayList<String> registers;

    public ListAdapter(Activity activity2, ArrayList<String> nameList2, ArrayList<String> reg) {
        this.nameList = nameList2;
        this.activity = activity2;
        this.registers = reg;
        for (int i = 0; i < nameList2.size(); i++) {
            this.attendanceList.add(new Boolean(true));
        }
    }

    public int getCount() {
        return this.nameList.size();
    }

    public Object getItem(int position) {
        return this.nameList.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(final int position, View v, ViewGroup parent) {
        if (v == null) {
            v = LayoutInflater.from(this.activity).inflate(C0520R.layout.list_ele, (ViewGroup) null);
        }
        final int pos = position;
        ((TextView) v.findViewById(C0520R.C0522id.attendanceName)).setText(this.nameList.get(position));
        final CheckBox checkBox = (CheckBox) v.findViewById(C0520R.C0522id.attMarker);
        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ListAdapter.this.attendanceList.set(pos, Boolean.valueOf(checkBox.isChecked()));
                Log.d("Attendance", ListAdapter.this.nameList.get(position).toString() + " is absent " + ListAdapter.this.attendanceList.get(position));
            }
        });
        return v;
    }

    public void saveAll() {
        int sts;
        for (int i = 0; i < this.nameList.size(); i++) {
            if (this.attendanceList.get(i).booleanValue()) {
                sts = 1;
            } else {
                sts = 0;
            }
            AppBase.handler.execAction("INSERT INTO ATTENDANCE VALUES('" + AttendanceActivity.time + "'," + AttendanceActivity.period + ",'" + this.registers.get(i) + "'," + sts + ");");
            this.activity.finish();
        }
    }
}
