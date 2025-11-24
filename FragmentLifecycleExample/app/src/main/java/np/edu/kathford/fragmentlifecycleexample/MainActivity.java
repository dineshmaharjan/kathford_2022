package np.edu.kathford.fragmentlifecycleexample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() callback method call");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() callback method call");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() callback method call");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() callback method call");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() callback method call");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() callback method call");
    }
}
