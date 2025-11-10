package np.edu.kathford.loginsignupexample;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private EditText fullNameEditText, mobileNUmberEditText, passwordEditText;
    private RadioGroup genderRadioGroup;
    private Spinner nationalitySpinner;
    private CheckBox termsAndConditionCheckBox;
    private Button signupButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //find view by id using its respective ids
        fullNameEditText = findViewById(R.id.fullNameEditText);
        mobileNUmberEditText = findViewById(R.id.mobileNumberEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        nationalitySpinner = findViewById(R.id.nationalitySpinner);
        termsAndConditionCheckBox = findViewById(R.id.termsAndConditionCheckBox);
        signupButton = findViewById(R.id.signupButton);

    }
}
