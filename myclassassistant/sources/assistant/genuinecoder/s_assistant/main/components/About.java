package assistant.genuinecoder.s_assistant.main.components;

import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import assistant.genuinecoder.s_assistant.C0520R;

public class About extends AppCompatActivity {
    Animation anim1;
    Animation anim2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0520R.layout.activity_about);
        moveViewToScreenCenter(findViewById(C0520R.C0522id.names));
        moveIcon(findViewById(C0520R.C0522id.imageViewAbout));
    }

    private void moveIcon(View view) {
        int[] originalPos = new int[2];
        view.getLocationOnScreen(originalPos);
        this.anim2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (originalPos[1] + 100));
        this.anim2.setDuration(2000);
        this.anim2.setFillAfter(true);
        view.startAnimation(this.anim2);
    }

    private void moveViewToScreenCenter(View view) {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int[] originalPos = new int[2];
        view.getLocationOnScreen(originalPos);
        this.anim1 = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (((((dm.heightPixels / 2) - (view.getMeasuredHeight() / 2)) - (dm.heightPixels - ((RelativeLayout) findViewById(C0520R.C0522id.ctr)).getMeasuredHeight())) - originalPos[1]) + ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
        this.anim1.setDuration(1500);
        this.anim1.setFillAfter(true);
        view.startAnimation(this.anim1);
    }
}
