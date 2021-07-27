package assistant.genuinecoder.s_assistant.main.components;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.support.p003v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;

public class SettingsActivity extends AppCompatPreferenceActivity {
    Activity base = this;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        addPreferencesFromResource(C0520R.xml.pref_general);
        findPreference("clear_schedule").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SettingsActivity.this.base);
                alert.setTitle("Are you sure ?");
                alert.setMessage("This will wipe your entire scheduling data");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (AppBase.handler.execAction("DROP TABLE SCHEDULE")) {
                            Toast.makeText(SettingsActivity.this.getBaseContext(), "Done", 1).show();
                            AppBase.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });
        findPreference("clear_attendance").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SettingsActivity.this.base);
                alert.setTitle("Are you sure ?");
                alert.setMessage("This will wipe your entire attendance data");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (AppBase.handler.execAction("DROP TABLE ATTENDANCE")) {
                            Toast.makeText(SettingsActivity.this.getBaseContext(), "Done", 1).show();
                            AppBase.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });
        findPreference("clear_notes").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SettingsActivity.this.base);
                alert.setTitle("Are you sure ?");
                alert.setMessage("This will wipe your entire Notes data");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (AppBase.handler.execAction("DROP TABLE NOTES")) {
                            Toast.makeText(SettingsActivity.this.getBaseContext(), "Done", 1).show();
                            AppBase.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });
        findPreference("clear_student").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SettingsActivity.this.base);
                alert.setTitle("Are you sure ?");
                alert.setMessage("This will wipe your entire Student data");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (AppBase.handler.execAction("DROP TABLE STUDENT")) {
                            Toast.makeText(SettingsActivity.this.getBaseContext(), "Done", 1).show();
                            AppBase.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
