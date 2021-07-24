package ro.scoalainformala.travroad.scenes.add_trip;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import ro.scoalainformala.travroad.R;

public class AddTripActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private MaterialButton saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        textInputLayout = findViewById(R.id.tripNameEditText);
        saveButton = findViewById(R.id.saveButton);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Objects.requireNonNull(textInputLayout.getEditText()).getText().toString();
                Log.d("tag", text);
            }
        });

    }

}

