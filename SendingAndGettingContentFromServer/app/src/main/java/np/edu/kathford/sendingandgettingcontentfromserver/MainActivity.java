package np.edu.kathford.sendingandgettingcontentfromserver;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText postTitleEditText, postMessageEditText;
    private Button submitButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postTitleEditText=findViewById(R.id.postTitleEditText);
        postMessageEditText=findViewById(R.id.postMessageEditText);
        submitButton=findViewById(R.id.submitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = postTitleEditText.getText().toString().trim();
                String message = postMessageEditText.getText().toString().trim();
            }
        });
    }
}
