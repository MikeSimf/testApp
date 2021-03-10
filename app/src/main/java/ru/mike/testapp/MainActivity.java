package ru.mike.testapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 0;
    private static final String USER_NAME = "Фамилия Имя Отчество";
    private static final String USER_BIRTH_DATE = "01.01.1970";
    private static final String USER_MAIL = "example@google.com";
    private static final String PARAM_NAME = "userName";
    private static final String PARAM_BIRTHDATE = "userBirthDate";
    private static final String PARAM_MAIL = "userMail";


    TextView tvUserName;
    TextView tvUserBirthDate;
    TextView tvUserMail;
    Button btnInfoEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvUserBirthDate = (TextView) findViewById(R.id.tvUserBirthDate);
        tvUserMail = (TextView) findViewById(R.id.tvUserMail);

        btnInfoEdit = (Button) findViewById(R.id.btnInfoEdit);

        if(savedInstanceState == null){
            tvUserName.setText(R.string.DEFAULT_NAME);
            tvUserBirthDate.setText(R.string.DEFAULT_BIRTHDATE);
            tvUserMail.setText(R.string.DEFAULT_MAIL);
        } else {

            tvUserBirthDate.setText(savedInstanceState.getString(USER_BIRTH_DATE));
            tvUserMail.setText(savedInstanceState.getString(USER_MAIL));
            tvUserName.setText(savedInstanceState.getString(USER_NAME));
        }

        btnInfoEdit.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(USER_MAIL, tvUserMail.getText().toString());
        outState.putString(USER_NAME, tvUserName.getText().toString());
        outState.putString(USER_BIRTH_DATE, tvUserBirthDate.getText().toString());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, UserInfoEditActivity.class);
        intent.putExtra(PARAM_NAME, tvUserName.getText().toString());
        intent.putExtra(PARAM_BIRTHDATE, tvUserBirthDate.getText().toString());
        intent.putExtra(PARAM_MAIL, tvUserMail.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                tvUserName.setText(data.getStringExtra(PARAM_NAME));
                tvUserBirthDate.setText(data.getStringExtra(PARAM_BIRTHDATE));
                tvUserMail.setText(data.getStringExtra(PARAM_MAIL));
                Toast.makeText(this, R.string.OK_RESULT_TOAST, Toast.LENGTH_SHORT).show();
            }
        }
    }
}