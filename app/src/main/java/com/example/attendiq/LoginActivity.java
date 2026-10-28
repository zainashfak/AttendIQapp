package com.example.attendiq;

import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.*;

public class LoginActivity extends BaseActivity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout root = root("Welcome back", "Sign in to keep your attendance on track.");
        ScrollView scroll = new ScrollView(this);
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.addView(text("Email address", 13, R.color.text_primary, true));
        EditText email = field("student@example.com", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        content.addView(email);
        content.addView(text("Password", 13, R.color.text_primary, true));
        EditText password = field("Enter your password", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        content.addView(password);
        Button forgot = textButton("Forgot password?");
        forgot.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        content.addView(forgot);
        Button login = button("Login");
        content.addView(login);
        TextView hint = text("Demo login: demo@example.com / 123456", 12, R.color.text_secondary, false);
        hint.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams h = new LinearLayout.LayoutParams(-1, -2);
        h.topMargin = dp(8);
        content.addView(hint, h);
        Button register = textButton("New to AttendIQ?  Create an account");
        content.addView(register);

        login.setOnClickListener(v -> {
            String em = email.getText().toString().trim();
            String pw = password.getText().toString();
            if (!validEmail(em)) { email.setError("Enter a valid email address"); return; }
            if (pw.isEmpty()) { password.setError("Enter your password"); return; }
            boolean demo = em.equalsIgnoreCase("demo@example.com") && pw.equals("123456");
            boolean saved = em.equalsIgnoreCase(prefs().getString("email", "")) && pw.equals(prefs().getString("password", ""));
            if (demo || saved) {
                prefs().edit().putString("session_email", em).apply();
                go(DashboardActivity.class);
                finish();
            } else {
                message("Account not found. Register first or use the demo login.");
            }
        });
        forgot.setOnClickListener(v -> go(ForgotPasswordActivity.class));
        register.setOnClickListener(v -> go(RegisterActivity.class));
        scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));
        setContentView(root);
    }
}
