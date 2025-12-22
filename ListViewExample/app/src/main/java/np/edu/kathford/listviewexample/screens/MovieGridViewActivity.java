package np.edu.kathford.listviewexample.screens;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.listviewexample.R;

public class MovieGridViewActivity extends AppCompatActivity {

    private GridView gridView;

    private String[] numbers = {"1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_layout);
        gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, numbers
        );

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String number = numbers[position];
                Toast.makeText(MovieGridViewActivity.this,
                        number,Toast.LENGTH_LONG).show();

            }
        });
    }
}
