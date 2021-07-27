package assistant.genuinecoder.s_assistant.main.profile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main5Activity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Activity activity = this;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_user = this.database.getReference();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_main5);
        final EditText adm = (EditText) findViewById(C0520R.C0522id.register_);
        this.table_user.addValueEventListener(new ValueEventListener() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<Main5Activity> cls = Main5Activity.class;
            }

            public void onDataChange(final DataSnapshot dataSnapshot) {
                for (DataSnapshot next : dataSnapshot.getChildren()) {
                    ((Button) Main5Activity.this.findViewById(C0520R.C0522id.loadForEdit)).setOnClickListener(new View.OnClickListener() {
                        static final /* synthetic */ boolean $assertionsDisabled = false;

                        static {
                            Class<Main5Activity> cls = Main5Activity.class;
                        }

                        public void onClick(View v) {
                            if (dataSnapshot.child("user1").child("STUDENTS").child(adm.getText().toString().toUpperCase()).exists()) {
                                try {
                                    String Name = dataSnapshot.child("user1").child("STUDENTS").child(adm.getText().toString().toUpperCase()).child("Name").getValue().toString();
                                    String Class = dataSnapshot.child("user1").child("STUDENTS").child(adm.getText().toString().toUpperCase()).child("Class").getValue().toString();
                                    String address = dataSnapshot.child("user1").child("STUDENTS").child(adm.getText().toString().toUpperCase()).child("Address").getValue().toString();
                                    String Contact = dataSnapshot.child("user1").child("STUDENTS").child(adm.getText().toString().toUpperCase()).child("Contact").getValue().toString();
                                    String rollno = dataSnapshot.child("user1").child("STUDENTS").child(adm.getText().toString().toUpperCase()).child("Roll No").getValue().toString();
                                    String str = "SELECT * FROM STUDENT WHERE regno = '" + adm.getText().toString().toUpperCase() + "'";
                                    ((EditText) Main5Activity.this.findViewById(C0520R.C0522id.edit_name_)).setText(Name);
                                    ((EditText) Main5Activity.this.findViewById(C0520R.C0522id.Class)).setText(Class);
                                    ((EditText) Main5Activity.this.findViewById(C0520R.C0522id.address)).setText(address);
                                    ((EditText) Main5Activity.this.findViewById(C0520R.C0522id.contact)).setText(Contact);
                                    ((EditText) Main5Activity.this.findViewById(C0520R.C0522id.roll)).setText(rollno);
                                } catch (Exception e) {
                                }
                            } else {
                                Toast.makeText(Main5Activity.this.getBaseContext(), "No Such Student", 1).show();
                            }
                        }
                    });
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ((Button) findViewById(C0520R.C0522id.buttonSAVEEDITS)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText name = (EditText) Main5Activity.this.findViewById(C0520R.C0522id.edit_name_);
                EditText Clas = (EditText) Main5Activity.this.findViewById(C0520R.C0522id.Class);
                EditText add = (EditText) Main5Activity.this.findViewById(C0520R.C0522id.address);
                EditText contact = (EditText) Main5Activity.this.findViewById(C0520R.C0522id.contact);
                EditText roll = (EditText) Main5Activity.this.findViewById(C0520R.C0522id.roll);
                DatabaseReference ss = Main5Activity.this.table_user.child("user1").child("STUDENTS").child(adm.getText().toString().toUpperCase());
                if (adm.length() == 0) {
                    Toast.makeText(Main5Activity.this.getBaseContext(), "fill", 1).show();
                } else if (name.length() == 0) {
                    Toast.makeText(Main5Activity.this.getBaseContext(), "fill name", 1).show();
                } else if (Clas.length() == 0) {
                    Toast.makeText(Main5Activity.this.getBaseContext(), "fill class", 1).show();
                } else if (add.length() == 0) {
                    Toast.makeText(Main5Activity.this.getBaseContext(), "fill address", 1).show();
                } else if (contact.length() == 0) {
                    Toast.makeText(Main5Activity.this.getBaseContext(), "fill contact", 1).show();
                } else if (roll.length() == 0) {
                    Toast.makeText(Main5Activity.this.getBaseContext(), "fill the roll no", 1).show();
                } else {
                    try {
                        DatabaseReference child = ss.child("Name");
                        child.setValue("" + name.getText().toString());
                        DatabaseReference child2 = ss.child("Class");
                        child2.setValue("" + Clas.getText().toString());
                        DatabaseReference child3 = ss.child("Address");
                        child3.setValue("" + add.getText().toString());
                        DatabaseReference child4 = ss.child("Contact");
                        child4.setValue("" + contact.getText().toString());
                        DatabaseReference child5 = ss.child("Roll No");
                        child5.setValue("" + Integer.parseInt(roll.getText().toString()));
                    } catch (Exception e) {
                        Context baseContext = Main5Activity.this.getBaseContext();
                        Toast.makeText(baseContext, "" + e, 1).show();
                    }
                }
                Main5Activity.this.table_user.addValueEventListener(new ValueEventListener() {
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("user1").child("STUDENTS").child(adm.getText().toString().toUpperCase()).getChildrenCount() == 6) {
                            Toast.makeText(Main5Activity.this.getBaseContext(), "Edit Saved", 1).show();
                            Main5Activity.this.finish();
                        } else {
                            Toast.makeText(Main5Activity.this.getBaseContext(), "Error Occured", 1).show();
                        }
                        Main5Activity.this.finish();
                    }

                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });
    }
}
