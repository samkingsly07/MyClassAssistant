package assistant.genuinecoder.s_assistant.main.profile;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;

public class EditStudentActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Activity activity = this;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_edit__student);
        ((Button) findViewById(C0520R.C0522id.loadForEdit)).setOnClickListener(new View.OnClickListener() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<EditStudentActivity> cls = EditStudentActivity.class;
            }

            public void onClick(View v) {
                Cursor cr = AppBase.handler.execQuery("SELECT * FROM STUDENT WHERE regno = '" + ((EditText) EditStudentActivity.this.findViewById(C0520R.C0522id.register_)).getText().toString().toUpperCase() + "'");
                if (cr == null || cr.getCount() == 0) {
                    Toast.makeText(EditStudentActivity.this.getBaseContext(), "No Such Student", 1).show();
                    return;
                }
                cr.moveToFirst();
                try {
                    ((EditText) EditStudentActivity.this.findViewById(C0520R.C0522id.edit_name_)).setText(cr.getString(0));
                    ((EditText) EditStudentActivity.this.findViewById(C0520R.C0522id.roll_)).setText(cr.getString(4));
                    ((EditText) EditStudentActivity.this.findViewById(C0520R.C0522id.contact_)).setText(cr.getString(3));
                } catch (Exception e) {
                }
            }
        });
        ((Button) findViewById(C0520R.C0522id.buttonSAVEEDITS)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String qu = "UPDATE STUDENT SET name = '" + ((EditText) EditStudentActivity.this.findViewById(C0520R.C0522id.edit_name_)).getText().toString() + "' ,  roll = " + ((EditText) EditStudentActivity.this.findViewById(C0520R.C0522id.roll_)).getText().toString() + " , contact = '" + ((EditText) EditStudentActivity.this.findViewById(C0520R.C0522id.contact_)).getText().toString() + "' WHERE regno = '" + ((EditText) EditStudentActivity.this.findViewById(C0520R.C0522id.register_)).getText().toString().toUpperCase() + "'";
                Log.d("EditStudentActivity", qu);
                if (AppBase.handler.execAction(qu)) {
                    Toast.makeText(EditStudentActivity.this.getBaseContext(), "Edit Saved", 1).show();
                    EditStudentActivity.this.activity.finish();
                    return;
                }
                Toast.makeText(EditStudentActivity.this.getBaseContext(), "Error Occured", 1).show();
            }
        });
    }
}
