package np.edu.kathford.passingdataexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView fullNameTextView, ageTextView, mobileNumberTextView;
    private Button okButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //declare the component using find view by id
        fullNameTextView = findViewById(R.id.fullNameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        mobileNumberTextView = findViewById(R.id.mobileNumberTextView);
        okButton = findViewById(R.id.okButton);

        Intent intent = getIntent();

        String fullName = intent.getStringExtra("full_name");
        int age = intent.getIntExtra("age", 0);
        boolean is_active = intent.getBooleanExtra("is_active",
                false);
        String mobileNumber = intent.getStringExtra("mobile");

        fullNameTextView.setText(fullName);
        ageTextView.setText(String.valueOf(age));
        mobileNumberTextView.setText(mobileNumber);

    }
}
