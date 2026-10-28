package com.example.attendiq;

import android.os.Bundle;
import android.content.Intent;
import android.view.Gravity;
import android.widget.*;

public class DashboardActivity extends BaseActivity {
    private LinearLayout module(String icon, String title, String description) {
        LinearLayout c = card();
        TextView i = text(icon, 25, R.color.blue, true);
        c.addView(i);
        TextView t = text(title, 17, R.color.text_primary, true);
        LinearLayout.LayoutParams tp = new LinearLayout.LayoutParams(-1, -2);
        tp.topMargin = dp(8);
        c.addView(t, tp);
        TextView d = text(description, 12, R.color.text_secondary, false);
        LinearLayout.LayoutParams dpv = new LinearLayout.LayoutParams(-1, -2);
        dpv.topMargin = dp(5);
        c.addView(d, dpv);
        return c;
    }

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        String name = prefs().getString("name", "Student");
        if (name.isEmpty()) name = "Student";
        LinearLayout root = root("Hello, " + name.split(" ")[0] + " 👋", "A clearer view of your semester starts here.");
        ScrollView scroll = new ScrollView(this);
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);

        LinearLayout summary = card();
        summary.setBackgroundColor(getColor(R.color.navy));
        TextView label = new TextView(this);
        label.setText("YOUR ATTENDANCE OVERVIEW");
        label.setTextSize(12);
        label.setTextColor(0xFFBFCFF2);
        summary.addView(label);
        TextView percent = new TextView(this);
        percent.setText("75%+");
        percent.setTextSize(34);
        percent.setTypeface(android.graphics.Typeface.DEFAULT, android.graphics.Typeface.BOLD);
        percent.setTextColor(android.graphics.Color.WHITE);
        summary.addView(percent);
        TextView desc = new TextView(this);
        desc.setText("Keep your attendance above the required threshold.");
        desc.setTextSize(13);
        desc.setTextColor(0xFFE2E9F8);
        summary.addView(desc);
        content.addView(summary);

        TextView section = text("Your study tools", 19, R.color.text_primary, true);
        LinearLayout.LayoutParams secp = new LinearLayout.LayoutParams(-1, -2);
        secp.topMargin = dp(22);
        secp.bottomMargin = dp(10);
        content.addView(section, secp);

        content.addView(module("▦", "My Courses", "Your courses and class timetable"));
        addGap(content, 10);
        content.addView(module("✓", "Mark Attendance", "Record present, absent or cancelled"));
        addGap(content, 10);
        content.addView(module("◎", "Safe-to-Skip Calculator", "Plan ahead and protect your percentage"));
        addGap(content, 10);
        content.addView(module("◷", "Reminders & Reports", "Coming in the next development phase"));

        Button profile = button("View Profile");
        content.addView(profile);
        profile.setOnClickListener(v -> go(ProfileActivity.class));
        Button logout = textButton("Log out");
        content.addView(logout);
        logout.setOnClickListener(v -> {
            prefs().edit().remove("session_email").apply();
            Intent i = new Intent(this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
        scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));
        setContentView(root);
    }
}
