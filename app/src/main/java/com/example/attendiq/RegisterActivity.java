package com.example.attendiq;

import android.os.Bundle;
import android.text.InputType;
import android.widget.*;

public class RegisterActivity extends BaseActivity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout root = root("Create account", "Start managing your class attendance.");
        ScrollView scroll = new ScrollView(this);
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        EditText name = field("Full name", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        EditText email = field("Email address", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        EditText password = field("Create password (6+ characters)", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        EditText confirm = field("Confirm password", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        content.addView(name); content.addView(email); content.addView(password); content.addView(confirm);
        Button create = button("Create account");
        content.addView(create);
        create.setOnClickListener(v -> {
            String n = name.getText().toString().trim();
            String em = email.getText().toString().trim();
            String pw = password.getText().toString();
            String cp = confirm.getText().toString();
            if (n.isEmpty()) { name.setError("Enter your name"); return; }
            if (!validEmail(em)) { email.setError("Enter a valid email"); return; }
            if (pw.length() < 6) { password.setError("Use at least 6 characters"); return; }
            if (!pw.equals(cp)) { confirm.setError("Passwords do not match"); return; }
            prefs().edit().putString("name", n).putString("email", em).putString("password", pw).apply();
            message("Account created. Please log in.");
            go(LoginActivity.class);
            finish();
        });
        Button login = textButton("Already have an account? Login");
        content.addView(login);
        login.setOnClickListener(v -> { go(LoginActivity.class); finish(); });
        scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));
        setContentView(root);
    }
}
