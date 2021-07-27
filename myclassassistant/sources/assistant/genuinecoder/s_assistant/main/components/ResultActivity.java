package assistant.genuinecoder.s_assistant.main.components;

import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResultActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_result_activity);
        EditText sgpa = (EditText) findViewById(C0520R.C0522id.sgpa);
        EditText percentage = (EditText) findViewById(C0520R.C0522id.percentage);
        TextView t = (TextView) findViewById(C0520R.C0522id.f59t);
        TextView t1 = (TextView) findViewById(C0520R.C0522id.f60t3);
        try {
            Bundle b = getIntent().getExtras();
            float final_sgpa = b.getFloat("final_sgpa");
            int flag = b.getInt("flag");
            float final_perc = b.getFloat("final_perc");
            if (flag == 0) {
                t.setText("Your CGPA is ");
                percentage.setVisibility(4);
                t1.setVisibility(4);
            }
            float final_sgpa2 = new BigDecimal((double) final_sgpa).setScale(2, RoundingMode.HALF_EVEN).floatValue();
            float final_perc2 = new BigDecimal((double) final_perc).setScale(2, RoundingMode.HALF_EVEN).floatValue();
            sgpa.setText(String.valueOf(final_sgpa2));
            percentage.setText(String.valueOf(final_perc2 + "%"));
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Exception Occured", 1).show();
        }
    }
}
