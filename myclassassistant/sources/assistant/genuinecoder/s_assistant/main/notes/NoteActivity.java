package assistant.genuinecoder.s_assistant.main.notes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.p000v4.view.InputDeviceCompat;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p003v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Activity activity = this;
    ArrayAdapter adapter;
    ArrayList contents;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    ListView listView;
    final DatabaseReference table_user = this.database.getReference();
    ArrayList titles;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_note);
        final SwipeRefreshLayout pullToRefresh = (SwipeRefreshLayout) findViewById(C0520R.C0522id.swipe);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                pullToRefresh.setColorSchemeColors(-16776961, InputDeviceCompat.SOURCE_ANY, -16776961);
                NoteActivity.this.loadNotes();
                pullToRefresh.setRefreshing(false);
            }
        });
        this.titles = new ArrayList();
        this.contents = new ArrayList();
        ((FloatingActionButton) findViewById(C0520R.C0522id.fab_Note)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NoteActivity.this.startActivity(new Intent(NoteActivity.this.activity, NoteCreate.class));
            }
        });
        this.listView = (ListView) findViewById(C0520R.C0522id.noteList);
        loadNotes();
        Button button = (Button) findViewById(C0520R.C0522id.button);
        this.listView.setOnItemClickListener(this);
        this.listView.setOnItemLongClickListener(this);
    }

    /* access modifiers changed from: private */
    public void loadNotes() {
        this.listView.setAdapter(this.adapter);
        this.table_user.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    NoteActivity.this.titles.clear();
                    NoteActivity.this.contents.clear();
                    NoteActivity.this.table_user.removeEventListener((ValueEventListener) this);
                    if (ds.child("note").getChildrenCount() == 0) {
                        Toast toast1 = Toast.makeText(NoteActivity.this, "No Notes Found ", 0);
                        toast1.setGravity(48, 0, 180);
                        toast1.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
                        ((TextView) toast1.getView().findViewById(16908299)).setTextColor(-1);
                        toast1.show();
                    } else {
                        long i = ds.child("note").getChildrenCount();
                        for (int j = 0; ((long) j) < i; j++) {
                            String d = "t" + j;
                            if (dataSnapshot.child("user1").child("note").child(d).exists()) {
                                NoteActivity.this.titles.add(ds.child("note").child(d).child("title").getValue().toString());
                                NoteActivity.this.contents.add(dataSnapshot.child("user1").child("note").child(d).child("title").getValue().toString());
                                NoteActivity.this.listView.setAdapter(NoteActivity.this.adapter);
                            }
                        }
                    }
                }
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        this.adapter = new ArrayAdapter(this, 17367043, this.titles);
        this.listView.setAdapter(this.adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(C0520R.C0524menu.note_menu, menu);
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this.activity);
        alert.setTitle(this.titles.get(position).toString());
        alert.setMessage(this.contents.get(position).toString());
        alert.setPositiveButton("OK", (DialogInterface.OnClickListener) null);
        alert.show();
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this.activity);
        final String title = this.titles.get(position).toString();
        final String body = this.contents.get(position).toString();
        alert.setTitle("Delete ?");
        alert.setMessage("Do you want to delete this note ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                NoteActivity.this.table_user.addValueEventListener(new ValueEventListener() {
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        NoteActivity.this.table_user.removeEventListener((ValueEventListener) this);
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            NoteActivity.this.table_user.child("user1").child("note").child(ds.child("position").child(title).child("pos").getValue().toString()).removeValue();
                            NoteActivity.this.table_user.child("user1").child("position").child(title).removeValue();
                        }
                    }

                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                if (AppBase.handler.execAction("DELETE FROM NOTES WHERE TITLE = '" + title + "' AND body = '" + body + "'")) {
                    NoteActivity noteActivity = NoteActivity.this;
                    Toast toast1 = Toast.makeText(noteActivity, "Deleted " + title, 1);
                    toast1.setGravity(48, 0, 180);
                    toast1.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
                    ((TextView) toast1.getView().findViewById(16908299)).setTextColor(-1);
                    toast1.show();
                    NoteActivity.this.startActivity(new Intent(NoteActivity.this, AppBase.class));
                } else {
                    NoteActivity.this.loadNotes();
                    Toast toast12 = Toast.makeText(NoteActivity.this, "Failed", 1);
                    toast12.setGravity(48, 0, 180);
                    toast12.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
                    ((TextView) toast12.getView().findViewById(16908299)).setTextColor(-1);
                    NoteActivity.this.listView.setAdapter(NoteActivity.this.adapter);
                    toast12.show();
                }
                dialog.dismiss();
            }
        });
        alert.setNegativeButton("No", (DialogInterface.OnClickListener) null);
        alert.show();
        return true;
    }

    public void refreshNote(MenuItem item) {
        loadNotes();
    }
}
