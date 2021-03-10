package ru.mike.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class UserInfoEditActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PARAM_NAME = "userName";
    private static final String PARAM_BIRTHDATE = "userBirthDate";
    private static final String PARAM_MAIL = "userMail";

    EditText editTextUserName;
    EditText editTextUserBirthDate;
    EditText editTextUserMail;
    Button btnInfoSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_edit);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextUserBirthDate = (EditText) findViewById(R.id.editTextUserBirthDate);
        editTextUserMail = (EditText) findViewById(R.id.editTextUserMail);

        btnInfoSave = (Button) findViewById(R.id.btnInfoSave);
        btnInfoSave.setOnClickListener(this);

        editTextUserName.setText(getIntent().getStringExtra(PARAM_NAME));
        editTextUserBirthDate.setText(getIntent().getStringExtra(PARAM_BIRTHDATE));
        editTextUserMail.setText(getIntent().getStringExtra(PARAM_MAIL));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra(PARAM_NAME, editTextUserName.getText().toString());
        intent.putExtra(PARAM_BIRTHDATE, editTextUserBirthDate.getText().toString());
        intent.putExtra(PARAM_MAIL, editTextUserMail.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}