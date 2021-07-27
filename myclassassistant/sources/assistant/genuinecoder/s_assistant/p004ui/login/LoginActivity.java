package assistant.genuinecoder.s_assistant.p004ui.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.p000v4.app.ActivityCompat;
import android.support.p000v4.widget.SwipeRefreshLayout;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import assistant.genuinecoder.s_assistant.main.AppBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/* renamed from: assistant.genuinecoder.s_assistant.ui.login.LoginActivity */
public class LoginActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private FirebaseAuth mAuth;
    private ProgressBar pgsBar;

    public void onBackPressed() {
        backButtonHandler();
    }

    public void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = getSharedPreferences("user_details", 0);
        Intent intent = new Intent(this, AppBase.class);
        if (pref.contains("username") && pref.contains("password")) {
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_login);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(C0520R.C0522id.swipe);
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.SEND_SMS", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"}, 1);
        this.firebaseAuth = FirebaseAuth.getInstance();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        final ProgressDialog progressDialog1 = new ProgressDialog(this);
        final EditText editText = (EditText) findViewById(C0520R.C0522id.username);
        final EditText editText2 = (EditText) findViewById(C0520R.C0522id.password);
        final SharedPreferences sharedPreferences = pref;
        final Intent intent2 = intent;
        ((Button) findViewById(C0520R.C0522id.login)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean connected;
                ConnectivityManager connectivityManager = (ConnectivityManager) LoginActivity.this.getSystemService("connectivity");
                if (connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
                    connected = true;
                    progressDialog1.dismiss();
                } else {
                    connected = false;
                    Toast toast1 = Toast.makeText(LoginActivity.this, "No Internet Connection!", 0);
                    toast1.setGravity(48, 0, 0);
                    toast1.getView().setBackgroundResource(C0520R.C0521drawable.sssss);
                    ((TextView) toast1.getView().findViewById(16908299)).setTextColor(-1);
                    toast1.show();
                }
                if (connected) {
                    final String userEmail = editText.getText().toString();
                    final String userPaswd = editText2.getText().toString();
                    progressDialog.setMessage("Signing in  Please Wait...");
                    if (userEmail.isEmpty()) {
                        editText.setError("Provide your Email first!");
                        editText.requestFocus();
                    } else if (userPaswd.isEmpty()) {
                        editText2.setError("Enter Password!");
                        editText2.requestFocus();
                    } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Fields Empty!", 0).show();
                    } else if (!userEmail.isEmpty() || !userPaswd.isEmpty()) {
                        progressDialog.show();
                        LoginActivity.this.firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd).addOnCompleteListener((Activity) LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    progressDialog.dismiss();
                                    Toast toast1 = Toast.makeText(LoginActivity.this, "Username or Password Incorrect!", 1);
                                    toast1.setGravity(48, 0, 0);
                                    toast1.getView().setBackgroundResource(C0520R.C0521drawable.sssss);
                                    ((TextView) toast1.getView().findViewById(16908299)).setTextColor(-1);
                                    toast1.show();
                                    return;
                                }
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("username", userEmail);
                                editor.putString("password", userPaswd);
                                editor.commit();
                                progressDialog.dismiss();
                                Toast toast12 = Toast.makeText(LoginActivity.this, "Login Successful", 1);
                                toast12.setGravity(48, 0, 0);
                                toast12.getView().setBackgroundResource(C0520R.C0521drawable.sssssss);
                                ((TextView) toast12.getView().findViewById(16908299)).setTextColor(-1);
                                toast12.show();
                                LoginActivity.this.startActivity(intent2);
                            }
                        });
                    } else {
                        progressDialog.dismiss();
                        Toast toast12 = Toast.makeText(LoginActivity.this, "Error!", 1);
                        toast12.setGravity(48, 0, 0);
                        toast12.getView().setBackgroundResource(C0520R.C0521drawable.sssss);
                        ((TextView) toast12.getView().findViewById(16908299)).setTextColor(-1);
                        toast12.show();
                    }
                }
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        Toast.makeText(getApplicationContext(), getString(C0520R.string.welcome) + model.getDisplayName(), 1).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString.intValue(), 0).show();
    }

    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Leave application?");
        alertDialog.setMessage("Are you sure you want to leave the application?");
        alertDialog.setIcon(C0520R.C0521drawable.ic_sync_black_24dp);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                LoginActivity.this.finishAffinity();
                System.exit(0);
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
}
