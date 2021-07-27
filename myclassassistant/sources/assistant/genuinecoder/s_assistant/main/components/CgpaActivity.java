package assistant.genuinecoder.s_assistant.main.components;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import assistant.genuinecoder.s_assistant.C0520R;

public class CgpaActivity extends AppCompatActivity {

    /* renamed from: b3 */
    Button f65b3;

    /* renamed from: c1 */
    EditText f66c1;

    /* renamed from: c2 */
    EditText f67c2;

    /* renamed from: c3 */
    EditText f68c3;

    /* renamed from: c4 */
    EditText f69c4;

    /* renamed from: c5 */
    EditText f70c5;

    /* renamed from: c6 */
    EditText f71c6;

    /* renamed from: c7 */
    EditText f72c7;

    /* renamed from: cg */
    float f73cg;

    /* renamed from: g1 */
    int f74g1 = 44;

    /* renamed from: g2 */
    int f75g2 = 28;

    /* renamed from: g3 */
    int f76g3 = 28;

    /* renamed from: g4 */
    int f77g4 = 28;

    /* renamed from: g5 */
    int f78g5 = 28;

    /* renamed from: g6 */
    int f79g6 = 28;

    /* renamed from: g7 */
    int f80g7 = 28;
    float sg1;
    float sg2;
    float sg3;
    float sg4;
    float sg5;
    float sg6;
    float sg7;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_cgpa);
        this.f66c1 = (EditText) findViewById(C0520R.C0522id.f51c1);
        this.f67c2 = (EditText) findViewById(C0520R.C0522id.f52c2);
        this.f68c3 = (EditText) findViewById(C0520R.C0522id.f53c3);
        this.f69c4 = (EditText) findViewById(C0520R.C0522id.f54c4);
        this.f70c5 = (EditText) findViewById(C0520R.C0522id.f55c5);
        this.f71c6 = (EditText) findViewById(C0520R.C0522id.f56c6);
        this.f72c7 = (EditText) findViewById(C0520R.C0522id.f57c7);
        this.f65b3 = (Button) findViewById(C0520R.C0522id.f50b3);
        this.f65b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CgpaActivity.this.sg1 = CgpaActivity.this.read(CgpaActivity.this.f66c1);
                CgpaActivity.this.sg2 = CgpaActivity.this.read(CgpaActivity.this.f67c2);
                CgpaActivity.this.sg3 = CgpaActivity.this.read(CgpaActivity.this.f68c3);
                CgpaActivity.this.sg4 = CgpaActivity.this.read(CgpaActivity.this.f69c4);
                CgpaActivity.this.sg5 = CgpaActivity.this.read(CgpaActivity.this.f70c5);
                CgpaActivity.this.sg6 = CgpaActivity.this.read(CgpaActivity.this.f71c6);
                CgpaActivity.this.sg7 = CgpaActivity.this.read(CgpaActivity.this.f72c7);
                if (CgpaActivity.this.sg1 == 0.0f) {
                    CgpaActivity.this.f74g1 = 0;
                }
                if (CgpaActivity.this.sg2 == 0.0f) {
                    CgpaActivity.this.f75g2 = 0;
                }
                if (CgpaActivity.this.sg3 == 0.0f) {
                    CgpaActivity.this.f76g3 = 0;
                }
                if (CgpaActivity.this.sg4 == 0.0f) {
                    CgpaActivity.this.f77g4 = 0;
                }
                if (CgpaActivity.this.sg5 == 0.0f) {
                    CgpaActivity.this.f78g5 = 0;
                }
                if (CgpaActivity.this.sg6 == 0.0f) {
                    CgpaActivity.this.f79g6 = 0;
                }
                if (CgpaActivity.this.sg7 == 0.0f) {
                    CgpaActivity.this.f80g7 = 0;
                }
                CgpaActivity.this.f73cg = (((((((CgpaActivity.this.sg1 * ((float) CgpaActivity.this.f74g1)) + (CgpaActivity.this.sg2 * ((float) CgpaActivity.this.f75g2))) + (CgpaActivity.this.sg3 * ((float) CgpaActivity.this.f76g3))) + (CgpaActivity.this.sg4 * ((float) CgpaActivity.this.f77g4))) + (CgpaActivity.this.sg5 * ((float) CgpaActivity.this.f78g5))) + (CgpaActivity.this.sg6 * ((float) CgpaActivity.this.f79g6))) + (CgpaActivity.this.sg7 * ((float) CgpaActivity.this.f80g7))) / ((float) ((((((CgpaActivity.this.f74g1 + CgpaActivity.this.f75g2) + CgpaActivity.this.f76g3) + CgpaActivity.this.f77g4) + CgpaActivity.this.f78g5) + CgpaActivity.this.f79g6) + CgpaActivity.this.f80g7));
                if (CgpaActivity.this.sg1 == 0.0f && CgpaActivity.this.sg2 == 0.0f && CgpaActivity.this.sg3 == 0.0f && CgpaActivity.this.sg4 == 0.0f && CgpaActivity.this.sg5 == 0.0f && CgpaActivity.this.sg6 == 0.0f && CgpaActivity.this.sg7 == 0.0f) {
                    Toast.makeText(CgpaActivity.this.getApplicationContext(), "Insufficient Data ", 1).show();
                } else if (((double) CgpaActivity.this.sg1) > 100.0d || ((double) CgpaActivity.this.sg2) > 100.0d || ((double) CgpaActivity.this.sg3) > 100.0d || ((double) CgpaActivity.this.sg4) > 100.0d || ((double) CgpaActivity.this.sg5) > 100.0d || ((double) CgpaActivity.this.sg6) > 100.0d || ((double) CgpaActivity.this.sg7) > 100.0d) {
                    Toast.makeText(CgpaActivity.this.getApplicationContext(), " Invalid SGPA", 0).show();
                } else {
                    Intent i3 = new Intent(CgpaActivity.this.getApplicationContext(), ResultActivity.class);
                    i3.putExtra("final_sgpa", CgpaActivity.this.f73cg);
                    i3.putExtra("flag", 0);
                    i3.putExtra("final_perc", 0);
                    CgpaActivity.this.startActivity(i3);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public float read(EditText c) {
        if (c.getText().toString().matches("")) {
            return 0.0f;
        }
        return Float.valueOf(c.getText().toString()).floatValue();
    }
}
