package com.devskiller.anonymizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ChangeActivity extends AppCompatActivity {
    private Button mSaveButton;
    private TextView mEmailTextView;
    private TextView mSkypeTextView;
    private TextView mPhoneTextView;
    public Data data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        //START YOUR CHANGE
        mEmailTextView = findViewById(R.id.edit_email);
        mSkypeTextView = findViewById(R.id.edit_skype);
        mPhoneTextView = findViewById(R.id.edit_phone);
        mSaveButton = findViewById(R.id.save_button);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mEmailTextView.getText().length() == 0) {
                    mEmailTextView.setError(getResources().getString(R.string.field_cannot_be_empty_error));
                } else if (!Patterns.EMAIL_ADDRESS.matcher(mEmailTextView.getText().toString()).matches()) {
                    mEmailTextView.setError(getResources().getString(R.string.invalid_email ));
                } else if (!Patterns.PHONE.matcher(mPhoneTextView.getText().toString()).matches()) {
                    mPhoneTextView.setError(getResources().getString(R.string.invalid_phone ));
                } else if (mSkypeTextView.getText().length() == 0) {
                    mSkypeTextView.setError(getResources().getString(R.string.invalid_skype ));
                } else {
                    Data.get().setEmail(mEmailTextView.getText().toString());
                    Data.get().setPhone(mPhoneTextView.getText().toString());
                    Data.get().setSkype(mSkypeTextView.getText().toString());
                    Intent intent = new Intent(ChangeActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        //END YOUR CHANGE
    }
}
