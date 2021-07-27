package assistant.genuinecoder.s_assistant.main.notes;

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

public class NoteCreate extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    EditText body;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    Spinner spinner;
    EditText sub;
    final DatabaseReference table_user = this.database.getReference();
    EditText title;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.note_create);
        ((Button) findViewById(C0520R.C0522id.noteSaveButton)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NoteCreate.this.saveData();
            }
        });
        this.spinner = (Spinner) findViewById(C0520R.C0522id.pinSpinner);
        this.spinner.setAdapter(new ArrayAdapter<>(this, 17367049, AppBase.divisions));
    }

    /* access modifiers changed from: private */
    public void saveData() {
        this.title = (EditText) findViewById(C0520R.C0522id.noteTitle);
        this.body = (EditText) findViewById(C0520R.C0522id.noteBody);
        this.sub = (EditText) findViewById(C0520R.C0522id.subjectNote);
        if (this.title.length() == 0) {
            Toast toast1 = Toast.makeText(this, "Fill the Title ", 1);
            toast1.setGravity(48, 0, 180);
            toast1.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
            ((TextView) toast1.getView().findViewById(16908299)).setTextColor(-1);
            toast1.show();
        } else if (this.body.length() == 0) {
            Toast toast12 = Toast.makeText(this, "Fill the Body ", 1);
            toast12.setGravity(48, 0, 180);
            toast12.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
            ((TextView) toast12.getView().findViewById(16908299)).setTextColor(-1);
            toast12.show();
        } else if (this.sub.length() == 0) {
            Toast toast = Toast.makeText(this, "Fill The Subject", 1);
            toast.setGravity(48, 0, 180);
            toast.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
            ((TextView) toast.getView().findViewById(16908299)).setTextColor(-1);
            toast.show();
        } else {
            this.table_user.addValueEventListener(new ValueEventListener() {
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String ss1 = "t" + ds.child("note").getChildrenCount();
                        try {
                            DatabaseReference ss = NoteCreate.this.table_user.child("user1").child("note").child(ss1);
                            ss.child("Subject").setValue(NoteCreate.this.sub.getText().toString());
                            ss.child("title").setValue(NoteCreate.this.title.getText().toString());
                            ss.child("Body").setValue(NoteCreate.this.body.getText().toString());
                            NoteCreate.this.table_user.child("user1").child("position").child(NoteCreate.this.title.getText().toString()).child("pos").setValue(ss1);
                            Toast toast1 = Toast.makeText(NoteCreate.this, "Note Created ", 1);
                            toast1.setGravity(48, 0, 180);
                            toast1.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
                            ((TextView) toast1.getView().findViewById(16908299)).setTextColor(-1);
                            toast1.show();
                            NoteCreate.this.table_user.removeEventListener((ValueEventListener) this);
                            NoteCreate.this.finish();
                        } catch (Exception e) {
                            Exception exc = e;
                            Toast toast12 = Toast.makeText(NoteCreate.this, "ERROR OCCURRED ", 1);
                            toast12.setGravity(48, 0, 180);
                            toast12.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
                            ((TextView) toast12.getView().findViewById(16908299)).setTextColor(-1);
                            toast12.show();
                            NoteCreate.this.finish();
                        }
                    }
                }

                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
    }
}
