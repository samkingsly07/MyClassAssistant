package assistant.genuinecoder.s_assistant.main.profile;

import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.widget.TextView;
import assistant.genuinecoder.s_assistant.C0520R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_user = this.database.getReference();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_main2);
        this.table_user.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String plate = ds.child("notes").child("title").getValue().toString();
                    String emails = ds.child("notes").child("title").getValue().toString();
                    TextView result = (TextView) Main2Activity.this.findViewById(C0520R.C0522id.txtDiameter);
                    TextView result1 = (TextView) Main2Activity.this.findViewById(C0520R.C0522id.txtDistance);
                    TextView textView = (TextView) Main2Activity.this.findViewById(C0520R.C0522id.txtName);
                    TextView result3 = (TextView) Main2Activity.this.findViewById(C0520R.C0522id.txtGravity);
                    if (ds.child("ss").getChildrenCount() == 1) {
                        ds.child("ss").child("sss").getRef().setValue("ss");
                        result.setText("NAME   : " + plate);
                    }
                    result1.setText("NAME   : " + plate);
                    result3.setText("Logged As:: " + emails);
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
