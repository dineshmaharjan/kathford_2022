package np.edu.kathford.fragmentwithuiexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FormFragment extends Fragment {
    private EditText fullNameEditText, addressEdiText, mobileNumberEditText;
    private Button submitButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fullNameEditText=view.findViewById(R.id.fullNameEditText);
        addressEdiText = view.findViewById(R.id.addressEditText);
        mobileNumberEditText= view.findViewById(R.id.mobileNumberEditText);
        submitButton = view.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName=fullNameEditText.getText().toString().trim();
                String address = addressEdiText.getText().toString().trim();
                String mobile = mobileNumberEditText.getText().toString().trim();

                Toast.makeText(getContext(),
                        " "+fullName+" "+address+" "+mobile,Toast.LENGTH_LONG).show();
            }
        });

    }
}
