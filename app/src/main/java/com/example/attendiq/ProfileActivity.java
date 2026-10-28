package com.example.attendiq;

import android.os.Bundle;
import android.content.Intent;
import android.widget.*;

public class ProfileActivity extends BaseActivity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout root = root("My profile", "Your account details.");
        LinearLayout c = card();
        TextView avatar = text("●", 42, R.color.blue, true);
        c.addView(avatar);
        String name = prefs().getString("name", "Demo Student");
        String email = prefs().getString("session_email", prefs().getString("email", "demo@example.com"));
        c.addView(text(name, 20, R.color.text_primary, true));
        TextView e = text(email, 14, R.color.text_secondary, false);
        LinearLayout.LayoutParams ep = new LinearLayout.LayoutParams(-1, -2);
        ep.topMargin = dp(5);
        c.addView(e, ep);
        LinearLayout.LayoutParams cp = new LinearLayout.LayoutParams(-1, -2);
        cp.topMargin = dp(16);
        root.addView(c, cp);

        LinearLayout info = card();
        TextView title = text("Account information", 17, R.color.text_primary, true);
        info.addView(title);
        info.addView(text("App: AttendIQ", 14, R.color.text_secondary, false));
        info.addView(text("Mode: Local demo account", 14, R.color.text_secondary, false));
        LinearLayout.LayoutParams ip = new LinearLayout.LayoutParams(-1, -2);
        ip.topMargin = dp(14);
        root.addView(info, ip);

        Button back = button("Back to dashboard");
        root.addView(back);
        back.setOnClickListener(v -> go(DashboardActivity.class));
        Button logout = textButton("Log out");
        root.addView(logout);
        logout.setOnClickListener(v -> {
            prefs().edit().remove("session_email").apply();
            Intent i = new Intent(this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
        setContentView(root);
    }
}
