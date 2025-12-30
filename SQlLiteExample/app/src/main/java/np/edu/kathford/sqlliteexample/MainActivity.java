package np.edu.kathford.sqlliteexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button addStudentButton, viewStudentButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addStudentButton=findViewById(R.id.addStudentButton);
        viewStudentButton=findViewById(R.id.listStudentButton);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addStudentIntent=new Intent(MainActivity.this,
                        StudentFormActivity.class);
                startActivity(addStudentIntent);

            }
        });

        viewStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewStudentIntent=new Intent(MainActivity.this,
                        StudentListActivity.class);
                startActivity(viewStudentIntent);

            }
        });

    }
}
