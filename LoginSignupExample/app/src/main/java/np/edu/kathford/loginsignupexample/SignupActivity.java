package np.edu.kathford.loginsignupexample;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SignupActivity extends AppCompatActivity {
    private EditText fullNameEditText, mobileNUmberEditText, passwordEditText;
    private RadioGroup genderRadioGroup;
    private Spinner nationalitySpinner;
    private CheckBox termsAndConditionCheckBox;
    private Button signupButton;

    private String fullName, mobileNumber, password;
    private String gender;
    private String nationality;
    private boolean isTermsChecked = false;


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

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullName = fullNameEditText.getText().toString().trim();
                mobileNumber = mobileNUmberEditText.getText().toString().trim();
                password = passwordEditText.getText().toString().trim();

                if(!fullName.isEmpty() && !mobileNumber.isEmpty()
                        && !password.isEmpty() && !gender.isEmpty()
                        && !nationality.isEmpty() && isTermsChecked){
                    Toast.makeText(SignupActivity.this, "Signup success",
                            Toast.LENGTH_LONG).show();
                    finish();

                }else{
                    Toast.makeText(SignupActivity.this,
                            "All fields are required",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.maleRadioButton == checkedId) {
                    gender = "Male";
                } else if (R.id.femaleRadioButton == checkedId) {
                    gender = "Female";
                } else {
                    gender = "Other";
                }

            }
        });

        nationalitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                nationality = nationalitySpinner.getSelectedItem().toString();
//                String[] nationalities=getResources().getStringArray(R.array.nationality);
//                nationality = nationalities[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        termsAndConditionCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isTermsChecked = isChecked;

            }
        });


    }
}
