package np.edu.kathford.passingdataexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText fullNameEditText, ageEditText, mobileNumberEditText;
    private Button submitButton;
    private TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //component declare using findview by id
        setContentView(R.layout.activity_main);
        fullNameEditText = findViewById(R.id.fullNameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        mobileNumberEditText = findViewById(R.id.mobileNumberEditText);
        resultTextView = findViewById(R.id.resultTextView);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = fullNameEditText.getText().toString().trim();
                int age = Integer.parseInt(ageEditText.getText().toString().trim());
                String mobileNumber = mobileNumberEditText.getText().toString().trim();

                //explicit intent
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                intent.putExtra("full_name", fullName);
                intent.putExtra("age", age);
                intent.putExtra("mobile", mobileNumber);
                intent.putExtra("is_active", true);

//                startActivity(intent);

                    startActivityForResult(intent, 201);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == resultCode && data != null){
            int acknowledge = data.getIntExtra("ack",0);
            resultTextView.setText(String.valueOf(acknowledge));
        }


    }
}
