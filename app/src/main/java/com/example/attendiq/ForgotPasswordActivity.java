package com.example.attendiq;

import android.os.Bundle;
import android.text.InputType;
import android.widget.*;

public class ForgotPasswordActivity extends BaseActivity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout root = root("Forgot password?", "Enter your registered email to start account recovery.");
        EditText email = field("Email address", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        root.addView(email);
        Button recover = button("Continue to reset password");
        root.addView(recover);
        TextView note = text("This student project simulates recovery locally; no email is sent.", 12, R.color.text_secondary, false);
        LinearLayout.LayoutParams np = new LinearLayout.LayoutParams(-1, -2);
        np.topMargin = dp(10);
        root.addView(note, np);
        Button back = textButton("Back to login");
        root.addView(back);
        recover.setOnClickListener(v -> {
            String em = email.getText().toString().trim();
            if (!validEmail(em)) { email.setError("Enter a valid email"); return; }
            if (!em.equalsIgnoreCase(prefs().getString("email", "")) && !em.equalsIgnoreCase("demo@example.com")) {
                email.setError("No local account found for this email"); return;
            }
            prefs().edit().putString("recovery_email", em).apply();
            message("Email accepted. Continue to reset your password.");
            go(ResetPasswordActivity.class);
        });
        back.setOnClickListener(v -> go(LoginActivity.class));
        setContentView(root);
    }
}
