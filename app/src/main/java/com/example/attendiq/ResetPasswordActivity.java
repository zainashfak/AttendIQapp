package com.example.attendiq;

import android.os.Bundle;
import android.text.InputType;
import android.widget.*;

public class ResetPasswordActivity extends BaseActivity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout root = root("Reset password", "Choose a new password for your AttendIQ account.");
        EditText password = field("New password (6+ characters)", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        EditText confirm = field("Confirm new password", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        root.addView(password); root.addView(confirm);
        Button save = button("Save new password");
        root.addView(save);
        Button back = textButton("Back to login");
        root.addView(back);
        save.setOnClickListener(v -> {
            String pw = password.getText().toString();
            String cp = confirm.getText().toString();
            String em = prefs().getString("recovery_email", "");
            if (em.isEmpty()) { message("Start from Forgot Password first."); return; }
            if (pw.length() < 6) { password.setError("Use at least 6 characters"); return; }
            if (!pw.equals(cp)) { confirm.setError("Passwords do not match"); return; }
            if (em.equalsIgnoreCase("demo@example.com")) {
                message("Demo account password cannot be changed.");
            } else {
                prefs().edit().putString("password", pw).remove("recovery_email").apply();
                message("Password updated successfully.");
            }
            go(LoginActivity.class);
            finish();
        });
        back.setOnClickListener(v -> go(LoginActivity.class));
        setContentView(root);
    }
}
