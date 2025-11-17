package np.edu.kathford.activitylifecycleexample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private String TAG= SecondActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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
