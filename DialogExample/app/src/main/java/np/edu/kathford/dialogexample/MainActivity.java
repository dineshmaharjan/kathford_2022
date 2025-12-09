package np.edu.kathford.dialogexample;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button logoutButton;
    private Button dialogFragmentButton;
    private Button customDialogButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoutButton = findViewById(R.id.logoutButton);
        dialogFragmentButton = findViewById(R.id.dialogFragmentButton);
        customDialogButton = findViewById(R.id.customDialogButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutDialog();

            }
        });

        dialogFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogoutDialogFragment logoutDialogFragment =
                        new LogoutDialogFragment();
                logoutDialogFragment.show(getSupportFragmentManager(),
                        "LogoutDialogFragment");
            }
        });


        customDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog();

            }
        });
    }

    private void customDialog(){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater()
                .inflate(R.layout.dialog_simple_interest, null);
        EditText principalEditText = view.findViewById(R.id.principalEditText);
        EditText timeEditText = view.findViewById(R.id.timeEditText);
        EditText rateEditText = view.findViewById(R.id.rateEditText);
        TextView resultTextView = view.findViewById(R.id.resultTextView);
        Button calculateButton = view.findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double principal = Double.parseDouble(principalEditText.getText().toString().trim());
                double rate = Double.parseDouble(rateEditText.getText().toString().trim());
                int time = Integer.parseInt(timeEditText.getText().toString().trim());

                double simpleInterest=(principal * time * rate)/100;

                resultTextView.setText("The result is: "+simpleInterest);

            }
        });

        builder.setView(view);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }


    private void logoutDialog() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this,
                                "OK button clicked", Toast.LENGTH_SHORT).show();

                    }
                });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
