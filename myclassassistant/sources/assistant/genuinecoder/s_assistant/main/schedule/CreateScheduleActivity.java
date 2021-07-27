package assistant.genuinecoder.s_assistant.main.schedule;

import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import java.util.ArrayList;

public class CreateScheduleActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ArrayAdapter adapterSpinner;
    Spinner classSelect;
    Spinner daySelect;
    ArrayAdapter days;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.schedule_create);
        this.classSelect = (Spinner) findViewById(C0520R.C0522id.classSelector);
        this.daySelect = (Spinner) findViewById(C0520R.C0522id.daySelector);
        this.adapterSpinner = new ArrayAdapter(this, 17367049, AppBase.divisions);
        this.classSelect.setAdapter(this.adapterSpinner);
        ArrayList<String> weekdays = new ArrayList<>();
        weekdays.add("MONDAY");
        weekdays.add("TUESDAY");
        weekdays.add("WEDNESDAY");
        weekdays.add("THURSDAY");
        weekdays.add("FRIDAY");
        weekdays.add("SATURDAY");
        weekdays.add("SUNDAY");
        this.days = new ArrayAdapter(this, 17367049, weekdays);
        this.daySelect.setAdapter(this.days);
        ((Button) findViewById(C0520R.C0522id.saveBUTTON_SCHEDULE)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CreateScheduleActivity.this.saveSchedule(v);
            }
        });
    }

    /* access modifiers changed from: private */
    public void saveSchedule(View v) {
        String daySelected = this.daySelect.getSelectedItem().toString();
        String classSelected = this.classSelect.getSelectedItem().toString();
        String subject = ((EditText) findViewById(C0520R.C0522id.subjectName)).getText().toString();
        if (subject.length() < 2) {
            Toast.makeText(getBaseContext(), "Enter Valid Subject Name", 0).show();
            return;
        }
        TimePicker timePicker = (TimePicker) findViewById(C0520R.C0522id.timePicker);
        String sql = "INSERT INTO SCHEDULE VALUES('" + classSelected + "','" + subject + "','" + timePicker.getCurrentHour().intValue() + ":" + timePicker.getCurrentMinute().intValue() + "','" + daySelected + "');";
        Log.d("Schedule", sql);
        if (AppBase.handler.execAction(sql)) {
            Toast.makeText(getBaseContext(), "Scheduling Done", 1).show();
            finish();
            return;
        }
        Toast.makeText(getBaseContext(), "Failed To Schedule", 1).show();
    }
}
