package np.edu.kathford.listviewexample.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import np.edu.kathford.listviewexample.R;

public class HomeActivity extends AppCompatActivity {

    private Button listViewButton, gridViewButton, recylerViewButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        listViewButton = findViewById(R.id.listViewButton);
        gridViewButton = findViewById(R.id.griViewViewButton);
        recylerViewButton = findViewById(R.id.recyclerViewButton);

        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listViewIntent = new Intent(HomeActivity.this,
                        MainActivity.class);
                startActivity(listViewIntent);

            }
        });

        gridViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent gridViewIntent = new Intent(HomeActivity.this,
//                        MovieGridViewActivity.class);
//                startActivity(gridViewIntent);

                Intent gridViewIntent = new Intent(HomeActivity.this,
                        GridViewMovieActivity.class);
                startActivity(gridViewIntent);

            }
        });

        recylerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent recyclerViewIntent= new Intent(
                        HomeActivity.this, RecyclerViewExampleActivity.class
                );
                startActivity(recyclerViewIntent);

            }
        });
    }
}
