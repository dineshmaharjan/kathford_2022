package np.edu.kathford.sqlliteexample;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    private  DbHandler dbHandler;

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
        dbHandler=new DbHandler(this);

        Intent intent=getIntent();
        if(intent!=null){
            int id=intent.getIntExtra("id",0);
            String fullName=intent.getStringExtra("name");
            String mobileNumber=intent.getStringExtra("mobile");
            String address=intent.getStringExtra("address");

            idEditText.setText(String.valueOf(id));
            fullNameEditText.setText(fullName);
            mobileNumberEditText.setText(mobileNumber);
            addressEditText.setText(address);





        }



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

               long insertedId= dbHandler.addStudent(student);

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
                int id=Integer.parseInt(idEditText.getText().toString().trim());
                String fullName=fullNameEditText.getText().toString().trim();
                String mobileNumber=mobileNumberEditText.getText().toString().trim();
                String address=addressEditText.getText().toString().trim();

                Student student= new Student(id, fullName, address, mobileNumber);
                int result=dbHandler.updateStudent(student);

                if(result>0){
                    Toast.makeText(StudentFormActivity.this, "Student info update successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(StudentFormActivity.this, "Failed to update student info", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
