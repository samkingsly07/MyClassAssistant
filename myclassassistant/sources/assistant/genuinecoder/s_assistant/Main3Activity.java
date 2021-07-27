package assistant.genuinecoder.s_assistant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.widget.TextView;
import assistant.genuinecoder.s_assistant.main.AppBase;
import assistant.genuinecoder.s_assistant.p004ui.login.LoginActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends AppCompatActivity {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_user = this.database.getReference();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_main3);
        SharedPreferences pref = getSharedPreferences("user_details", 0);
        Intent intent = new Intent(this, AppBase.class);
        Intent inti = new Intent(this, LoginActivity.class);
        if (!pref.contains("username") || !pref.contains("password")) {
            startActivity(inti);
            return;
        }
        this.table_user.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot next : dataSnapshot.getChildren()) {
                    ((TextView) Main3Activity.this.findViewById(C0520R.C0522id.sss)).setText("NAME   : ");
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        intent.setFlags(67174400);
        startActivity(intent);
    }
}
