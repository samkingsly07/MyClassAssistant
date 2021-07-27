package assistant.genuinecoder.s_assistant.main.profile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentRegistration extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Activity activity = this;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    Spinner spinner;
    final DatabaseReference table_user = this.database.getReference();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_student__registartion);
        this.spinner = (Spinner) findViewById(C0520R.C0522id.spinner);
        this.spinner.setAdapter(new ArrayAdapter<>(this, 17367049, AppBase.divisions));
        ((Button) findViewById(C0520R.C0522id.buttonSAVE)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StudentRegistration.this.saveToDatabase(v);
            }
        });
    }

    public void saveToDatabase(View view) {
        EditText name = (EditText) findViewById(C0520R.C0522id.edit_name);
        EditText roll = (EditText) findViewById(C0520R.C0522id.roll);
        final EditText register = (EditText) findViewById(C0520R.C0522id.register);
        EditText contact = (EditText) findViewById(C0520R.C0522id.contact);
        String classSelected = this.spinner.getSelectedItem().toString();
        if (name.getText().length() < 2 || roll.getText().length() == 0 || register.getText().length() < 2 || contact.getText().length() < 2 || classSelected.length() < 2) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this.activity);
            alert.setTitle("Invalid");
            alert.setMessage("Insufficient Data");
            alert.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
            alert.show();
            return;
        }
        DatabaseReference child = this.table_user.child("user1").child("STUDENTS").child(register.getText().toString().toUpperCase()).child("Name");
        child.setValue("" + name.getText().toString());
        DatabaseReference ss = this.table_user.child("user1").child("STUDENTS").child(register.getText().toString().toUpperCase());
        DatabaseReference child2 = ss.child("Class");
        child2.setValue("" + classSelected);
        DatabaseReference child3 = ss.child("Register");
        child3.setValue("" + register.getText().toString().toUpperCase());
        DatabaseReference child4 = ss.child("Contact");
        child4.setValue("" + contact.getText().toString());
        DatabaseReference child5 = ss.child("Roll No");
        child5.setValue("" + Integer.parseInt(roll.getText().toString()));
        this.table_user.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("user1").child("STUDENTS").child(register.getText().toString().toUpperCase()).exists()) {
                    Toast toast1 = Toast.makeText(StudentRegistration.this, "Student Added ", 1);
                    toast1.setGravity(48, 0, 180);
                    toast1.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
                    ((TextView) toast1.getView().findViewById(16908299)).setTextColor(-1);
                    toast1.show();
                    StudentRegistration.this.finish();
                }
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
