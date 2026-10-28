package com.example.attendiq;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class BaseActivity extends Activity {
    protected int dp(float v) { return (int)(v * getResources().getDisplayMetrics().density + 0.5f); }

    protected LinearLayout root(String title, String subtitle) {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(24), dp(22), dp(24), dp(22));
        root.setBackgroundColor(getColor(R.color.background));
        root.setFocusableInTouchMode(true);

        TextView brand = text("AttendIQ", 22, R.color.blue, true);
        root.addView(brand, new LinearLayout.LayoutParams(-1, -2));
        TextView heading = text(title, 28, R.color.text_primary, true);
        LinearLayout.LayoutParams hp = new LinearLayout.LayoutParams(-1, -2);
        hp.topMargin = dp(28);
        root.addView(heading, hp);
        TextView sub = text(subtitle, 14, R.color.text_secondary, false);
        LinearLayout.LayoutParams sp = new LinearLayout.LayoutParams(-1, -2);
        sp.topMargin = dp(7);
        sp.bottomMargin = dp(18);
        root.addView(sub, sp);
        return root;
    }

    protected TextView text(String value, int size, int colorRes, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(getColor(colorRes));
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }

    protected EditText field(String hint, int inputType) {
        EditText e = new EditText(this);
        e.setSingleLine(true);
        e.setTextSize(15);
        e.setHint(hint);
        e.setInputType(inputType);
        e.setPadding(dp(14), dp(12), dp(14), dp(12));
        e.setBackgroundResource(R.drawable.bg_input);
        e.setTextColor(getColor(R.color.text_primary));
        e.setHintTextColor(getColor(R.color.text_secondary));
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, dp(52));
        p.bottomMargin = dp(12);
        e.setLayoutParams(p);
        return e;
    }

    protected Button button(String label) {
        Button b = new Button(this);
        b.setText(label);
        b.setAllCaps(false);
        b.setTextSize(15);
        b.setTextColor(Color.WHITE);
        b.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        b.setBackgroundResource(R.drawable.bg_primary_button);
        b.setPadding(dp(12), dp(8), dp(12), dp(8));
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, dp(52));
        p.topMargin = dp(6);
        p.bottomMargin = dp(6);
        b.setLayoutParams(p);
        return b;
    }

    protected Button textButton(String label) {
        Button b = new Button(this);
        b.setText(label);
        b.setAllCaps(false);
        b.setTextSize(14);
        b.setTextColor(getColor(R.color.blue));
        b.setBackgroundColor(Color.TRANSPARENT);
        b.setPadding(dp(8), dp(4), dp(8), dp(4));
        return b;
    }

    protected void message(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected SharedPreferences prefs() {
        return getSharedPreferences("attendiq_prefs", MODE_PRIVATE);
    }

    protected void go(Class<?> target) {
        startActivity(new Intent(this, target));
    }

    protected boolean validEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    protected void addGap(LinearLayout root, int height) {
        View gap = new View(this);
        root.addView(gap, new LinearLayout.LayoutParams(1, dp(height)));
    }

    protected LinearLayout card() {
        LinearLayout c = new LinearLayout(this);
        c.setOrientation(LinearLayout.VERTICAL);
        c.setPadding(dp(16), dp(16), dp(16), dp(16));
        c.setBackgroundResource(R.drawable.bg_card);
        return c;
    }
}
