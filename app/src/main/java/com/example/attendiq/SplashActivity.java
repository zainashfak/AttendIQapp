package com.example.attendiq;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.*;

public class SplashActivity extends BaseActivity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(dp(28), dp(24), dp(28), dp(24));
        layout.setBackgroundColor(getColor(R.color.navy));

        TextView logo = new TextView(this);
        logo.setText("A");
        logo.setTextSize(42);
        logo.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        logo.setTextColor(Color.WHITE);
        logo.setGravity(Gravity.CENTER);
        logo.setBackgroundResource(R.drawable.bg_logo);
        layout.addView(logo, new LinearLayout.LayoutParams(dp(88), dp(88)));

        TextView name = new TextView(this);
        name.setText("AttendIQ");
        name.setTextSize(34);
        name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        name.setTextColor(Color.WHITE);
        name.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams np = new LinearLayout.LayoutParams(-1, -2);
        np.topMargin = dp(22);
        layout.addView(name, np);

        TextView tagline = new TextView(this);
        tagline.setText("Your attendance, under control.");
        tagline.setTextSize(15);
        tagline.setTextColor(0xFFD7E1F5);
        tagline.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams tp = new LinearLayout.LayoutParams(-1, -2);
        tp.topMargin = dp(8);
        layout.addView(tagline, tp);

        setContentView(layout);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }, 1400);
    }
}
