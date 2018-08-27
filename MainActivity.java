package com.devskiller.anonymizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mEmailTextView;
    private TextView mSkypeTextView;
    private TextView mPhoneTextView;
    private Button mEditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmailTextView = findViewById(R.id.email);
        mSkypeTextView = findViewById(R.id.skype);
        mPhoneTextView = findViewById(R.id.phone);
        mEditButton = findViewById(R.id.edit_button);
        //START YOUR CHANGE
        mEditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChangeActivity.class);
                startActivity(intent);
            }
        });
        //END YOUR CHANGE
    }

    @Override
    protected void onResume() {
        super.onResume();
        Data data = Data.get();

        mEmailTextView.setText(Anonymizer.anonymizeEmail(data.getEmail(), 'x'));
        mSkypeTextView.setText(Anonymizer.anonymizeSkype(data.getSkype(), '*'));
        mPhoneTextView.setText(Anonymizer.anonymizePhone(data.getPhone(), 'X', 7));
    }
}
