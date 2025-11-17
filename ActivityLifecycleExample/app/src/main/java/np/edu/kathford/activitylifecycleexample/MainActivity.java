package np.edu.kathford.activitylifecycleexample;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button swapButton;

    private String TAG= MainActivity.class.getSimpleName();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swapButton = findViewById(R.id.swapButton);

        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //explicit intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Log.d(TAG, "onCreate() callback method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() callback method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() callback method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() callback method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() callback method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() callback method");
    }
}
