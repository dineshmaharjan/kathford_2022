package np.edu.kathford.loginsignupexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText passwordEditText;

    private Button loginButton;

    private TextView signupTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        signupTextView = findViewById(R.id.signupTextView);

//        loginButton.setOnClickListener(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
//                Log.d("username", username);
//                Log.d("password", password);
//                boolean isSuccess = validateLogin(username, password);
                if (validateLogin(username, password)) {
                    Toast.makeText(LoginActivity.this, "Login Successful",
                            Toast.LENGTH_SHORT).show();
                    userNameEditText.setText(null);
                    passwordEditText.setText(null);
                }

            }
        });

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //routing or navigation
                Intent intent = new Intent(LoginActivity.this,
                        SignupActivity.class);
                startActivity(intent);
            }
        });


    }


    private boolean validateLogin(String username, String password) {
        if (username.isEmpty()) {
            userNameEditText.setError("Username is required");
            return false;
        }
        if (password.isEmpty()) {
            passwordEditText.setError("Password is required");
            return false;
        }
        return true;
    }

//    @Override
//    public void onClick(View v) {
//
//    }
}
