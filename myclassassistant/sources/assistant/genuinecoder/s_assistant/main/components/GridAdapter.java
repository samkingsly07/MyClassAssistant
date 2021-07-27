package assistant.genuinecoder.s_assistant.main.components;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.p000v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import assistant.genuinecoder.s_assistant.main.attendance.AttendanceActivity;
import assistant.genuinecoder.s_assistant.main.notes.NoteActivity;
import assistant.genuinecoder.s_assistant.main.profile.ProfileActivity;
import assistant.genuinecoder.s_assistant.main.schedule.Scheduler;
import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    public static Activity activity;
    ArrayList names;

    public GridAdapter(Activity activity2, ArrayList names2) {
        activity = activity2;
        this.names = names2;
    }

    public static void makeNotification(String userIntrouble) {
        Log.d("NOTIFICATION", "Building..........");
        PendingIntent pIntent = PendingIntent.getActivity(activity, 0, new Intent(activity.getApplicationContext(), NoteActivity.class), 0);
        Notification noti = new NotificationCompat.Builder(activity.getBaseContext()).setTicker("Ticker Title").setContentTitle("Notes Are Available For this subject").setSmallIcon(C0520R.C0521drawable.ic_notes).setStyle(new NotificationCompat.BigTextStyle().bigText(userIntrouble)).setContentIntent(pIntent).setSound(Uri.parse(PreferenceManager.getDefaultSharedPreferences(activity.getBaseContext()).getString("Notification_Sound", Settings.System.DEFAULT_RINGTONE_URI.toString()))).build();
        noti.contentIntent = pIntent;
        noti.flags = 16;
        Activity activity2 = activity;
        Activity activity3 = activity;
        ((NotificationManager) activity2.getSystemService("notification")).notify(0, noti);
    }

    public int getCount() {
        return this.names.size();
    }

    public Object getItem(int position) {
        return this.names.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View v, ViewGroup parent) {
        View v2;
        int i = position;
        if (v == null) {
            v2 = LayoutInflater.from(activity).inflate(C0520R.layout.grid_layout, (ViewGroup) null);
        } else {
            v2 = v;
        }
        TextView textView = (TextView) v2.findViewById(C0520R.C0522id.namePlacer);
        ImageView imageView = (ImageView) v2.findViewById(C0520R.C0522id.imageHolder);
        if (this.names.get(i).toString().equals("ATTENDANCE")) {
            imageView.setImageResource(C0520R.C0521drawable.ic_attendance);
            v2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    new createRequest().show(GridAdapter.activity.getFragmentManager(), "Select");
                }
            });
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(2000);
            scaleAnimation.setRepeatMode(-1);
            scaleAnimation.setRepeatCount(-1);
            imageView.startAnimation(scaleAnimation);
        } else if (this.names.get(i).toString().equals("SCHEDULER")) {
            imageView.setImageResource(C0520R.C0521drawable.ic_schedule);
            v2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GridAdapter.activity.startActivity(new Intent(GridAdapter.activity, Scheduler.class));
                }
            });
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setFillAfter(true);
            scaleAnimation2.setDuration(2000);
            scaleAnimation2.setRepeatMode(-1);
            scaleAnimation2.setRepeatCount(-1);
            imageView.startAnimation(scaleAnimation2);
        } else if (this.names.get(i).toString().equals("NOTES")) {
            imageView.setImageResource(C0520R.C0521drawable.ic_notes);
            v2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GridAdapter.activity.startActivity(new Intent(GridAdapter.activity, NoteActivity.class));
                }
            });
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setFillAfter(true);
            scaleAnimation3.setDuration(2000);
            scaleAnimation3.setRepeatMode(-1);
            scaleAnimation3.setRepeatCount(-1);
            imageView.startAnimation(scaleAnimation3);
        } else if (this.names.get(i).toString().equals("PROFILE")) {
            imageView.setImageResource(C0520R.C0521drawable.ic_profile);
            v2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GridAdapter.activity.startActivity(new Intent(GridAdapter.activity, ProfileActivity.class));
                }
            });
            ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation4.setFillAfter(true);
            scaleAnimation4.setDuration(2000);
            scaleAnimation4.setRepeatMode(-1);
            scaleAnimation4.setRepeatCount(-1);
            imageView.startAnimation(scaleAnimation4);
        } else if (this.names.get(i).toString().equals("CGPA CALCULATOR")) {
            imageView.setImageResource(C0520R.C0521drawable.ic_cgpa);
            v2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GridAdapter.activity.startActivity(new Intent(GridAdapter.activity, CgpaActivity.class));
                }
            });
            ScaleAnimation scaleAnimation5 = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation5.setFillAfter(true);
            scaleAnimation5.setDuration(2000);
            scaleAnimation5.setRepeatMode(-1);
            scaleAnimation5.setRepeatCount(-1);
            imageView.startAnimation(scaleAnimation5);
        }
        textView.setText(this.names.get(i).toString());
        return v2;
    }

    public static class createRequest extends DialogFragment {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
            Class<GridAdapter> cls = GridAdapter.class;
        }

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View v = getActivity().getLayoutInflater().inflate(C0520R.layout.pick_period, (ViewGroup) null);
            final DatePicker datePicker = (DatePicker) v.findViewById(C0520R.C0522id.datePicker);
            final EditText hour = (EditText) v.findViewById(C0520R.C0522id.periodID);
            final Spinner spn = (Spinner) v.findViewById(C0520R.C0522id.spinnerSubject);
            ArrayList<String> subs = new ArrayList<>();
            subs.add("Not Specified");
            Cursor cr = AppBase.handler.execQuery("SELECT DISTINCT sub FROM NOTES");
            if (cr != null) {
                cr.moveToFirst();
                while (!cr.isAfterLast()) {
                    subs.add(cr.getString(0));
                    Log.d("GridAdapter.class", "Cached " + cr.getString(0));
                    cr.moveToNext();
                }
            } else {
                Log.d("GridAdapter.class", "No SUBS" + cr.getString(0));
            }
            spn.setAdapter(new ArrayAdapter<>(GridAdapter.activity, 17367049, subs));
            builder.setView(v).setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    int day = datePicker.getDayOfMonth();
                    String date = datePicker.getYear() + "-" + (datePicker.getMonth() + 1) + "-" + day;
                    Cursor cr = AppBase.handler.execQuery("SELECT title FROM NOTES where sub = '" + spn.getSelectedItem().toString() + "'");
                    String subnames = "";
                    if (cr != null) {
                        cr.moveToFirst();
                        while (!cr.isAfterLast()) {
                            subnames = subnames + cr.getString(0) + "\n";
                            cr.moveToNext();
                        }
                    }
                    GridAdapter.makeNotification(subnames);
                    Cursor cursor = AppBase.handler.execQuery("SELECT * FROM ATTENDANCE WHERE datex = '" + date + "' AND hour = " + hour.getText() + ";");
                    if (cursor == null || cursor.getCount() == 0) {
                        Intent launchinIntent = new Intent(AppBase.activity, AttendanceActivity.class);
                        launchinIntent.putExtra("DATE", date);
                        launchinIntent.putExtra("PERIOD", hour.getText().toString());
                        AppBase.activity.startActivity(launchinIntent);
                        return;
                    }
                    Toast.makeText(createRequest.this.getActivity(), "Period Already Added", 1).show();
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
            return builder.create();
        }
    }
}
