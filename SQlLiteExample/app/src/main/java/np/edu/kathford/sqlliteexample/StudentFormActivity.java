package np.edu.kathford.sqlliteexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.sqlliteexample.handler.DbHandler;
import np.edu.kathford.sqlliteexample.models.Student;

public class StudentFormActivity  extends AppCompatActivity {
    private EditText idEditText, fullNameEditText,
            addressEditText, mobileNumberEditText;

    private Button addStudentButton, updateStudentInfoButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        idEditText=findViewById(R.id.studentIdEditText);
        fullNameEditText=findViewById(R.id.fullNameEditText);
        addressEditText=findViewById(R.id.addressEditText);
        mobileNumberEditText=findViewById(R.id.mobileNumberEditTexrt);
        addStudentButton=findViewById(R.id.addStudentButton);
        updateStudentInfoButton=findViewById(R.id.updateButton);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullName=fullNameEditText.getText().toString().trim();
                String mobileNumber=mobileNumberEditText.getText().toString().trim();
                String address=addressEditText.getText().toString().trim();

                Student student=new Student();
                student.setFullName(fullName);
                student.setAddress(address);
                student.setMobileNumber(mobileNumber);

                DbHandler handler=new DbHandler(StudentFormActivity.this);
               long insertedId= handler.addStudent(student);

               if(insertedId>0){
                   Toast.makeText(StudentFormActivity.this,
                           "Student Record Added Successfully",
                           Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(StudentFormActivity.this,
                           "Unable to add student record",
                           Toast.LENGTH_SHORT).show();
               }


            }
        });


        updateStudentInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
