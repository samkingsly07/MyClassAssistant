package assistant.genuinecoder.s_assistant.main.components;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.p004ui.login.LoginActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class pro extends AppCompatActivity {
    /* access modifiers changed from: private */
    public static int RESULT_LOAD_IMAGE = 1;
    static final String TAG = "ViewDatabase";
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    Intent intent;
    private DatabaseReference mDatabase;
    private ListView mListView;
    SharedPreferences prf;
    TextView result;
    final DatabaseReference table_user = this.database.getReference();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.layout);
        this.table_user.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String plate = ds.child("notes").child("title").getValue().toString();
                    ((TextView) pro.this.findViewById(C0520R.C0522id.resultView)).setText("Logged As:: " + plate);
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.prf = getSharedPreferences("user_details", 0);
        this.intent = new Intent(this, LoginActivity.class);
        ((Button) findViewById(C0520R.C0522id.btnLogOut)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = pro.this.prf.edit();
                editor.clear();
                editor.commit();
                pro.this.startActivity(pro.this.intent);
                pro.this.finish();
            }
        });
        ((Button) findViewById(C0520R.C0522id.buttonLoadPicture)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                pro.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), pro.RESULT_LOAD_IMAGE);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == -1 && data != null) {
            String[] filePathColumn = {"_data"};
            Cursor cursor = getContentResolver().query(data.getData(), filePathColumn, (String) null, (String[]) null, (String) null);
            cursor.moveToFirst();
            String picturePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
            cursor.close();
            ((ImageView) findViewById(C0520R.C0522id.imgView)).setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }
}
