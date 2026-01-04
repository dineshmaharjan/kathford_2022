package np.edu.kathford.sqlliteexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import np.edu.kathford.sqlliteexample.handler.DbHandler;
import np.edu.kathford.sqlliteexample.models.Student;

public class StudentListActivity  extends AppCompatActivity {
    private ListView studentListView;
    private DbHandler dbHandler;

    private ArrayList<Student> studentArrayList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);
        studentListView=findViewById(R.id.studentListView);
        dbHandler=new DbHandler(this);

        studentArrayList=dbHandler.getAllStudents();

        ArrayAdapter<Student> adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                studentArrayList);
        studentListView.setAdapter(adapter);

        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student=studentArrayList.get(position);
                Intent intent= new Intent(StudentListActivity.this,
                        StudentFormActivity.class);
                intent.putExtra("id", student.getId());
                intent.putExtra("name", student.getFullName());
                intent.putExtra("mobile", student.getMobileNumber());
                intent.putExtra("address", student.getAddress());
                startActivity(intent);

            }
        });


    }
}
