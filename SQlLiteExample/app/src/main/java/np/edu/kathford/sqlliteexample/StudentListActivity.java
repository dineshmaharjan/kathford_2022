package np.edu.kathford.sqlliteexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import np.edu.kathford.sqlliteexample.handler.DbHandler;
import np.edu.kathford.sqlliteexample.models.Student;

public class StudentListActivity extends AppCompatActivity {
    private ListView studentListView;
    private DbHandler dbHandler;

    private ArrayList<Student> studentArrayList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);
        studentListView = findViewById(R.id.studentListView);
        dbHandler = new DbHandler(this);

        studentArrayList = dbHandler.getAllStudents();

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                studentArrayList);
        studentListView.setAdapter(adapter);

        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = studentArrayList.get(position);
                Intent intent = new Intent(StudentListActivity.this,
                        StudentFormActivity.class);
                intent.putExtra("id", student.getId());
                intent.putExtra("name", student.getFullName());
                intent.putExtra("mobile", student.getMobileNumber());
                intent.putExtra("address", student.getAddress());
                startActivity(intent);

            }
        });

        studentListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Student student = studentArrayList.get(position);
                confirmationDialog(student.getId());


                return true;
            }
        });


    }


    public void confirmationDialog(int studentId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Confirmation")
                .setMessage("Are you sure you want to delete this Info?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int result = dbHandler.deleteStudent(studentId);
                        if (result > 0) {
                            dialog.dismiss();

                        } else {
                            Toast.makeText(StudentListActivity.this,
                                    "Unable to delete this info", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
