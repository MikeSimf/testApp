package ru.mike.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class UserInfoEditActivity extends AppCompatActivity implements View.OnClickListener {

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

        editTextUserName.setText(getIntent().getStringExtra("userName"));
        editTextUserBirthDate.setText(getIntent().getStringExtra("userBirthDate"));
        editTextUserMail.setText(getIntent().getStringExtra("userMail"));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("userName", editTextUserName.getText().toString());
        intent.putExtra("userBirthDate", editTextUserBirthDate.getText().toString());
        intent.putExtra("userMail", editTextUserMail.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}