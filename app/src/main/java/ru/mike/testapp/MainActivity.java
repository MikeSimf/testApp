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
    private static final String USER_NAME = "1";
    private static final String USER_BIRTH_DATE = "2";
    private static final String USER_MAIL = "3";


    TextView tvUserName;
    TextView tvUserBirthDate;
    TextView tvUserMail;
    Button btnInfoEdit;

    String userName = "Макеев Иван Николаевич";
    String userBirthDate = "01.01.1991";
    String userMail = "makeev_in@list.ru";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvUserBirthDate = (TextView) findViewById(R.id.tvUserBirthDate);
        tvUserMail = (TextView) findViewById(R.id.tvUserMail);

        btnInfoEdit = (Button) findViewById(R.id.btnInfoEdit);

        if(savedInstanceState == null){
            tvUserName.setText(userName);
            tvUserBirthDate.setText(userBirthDate);
            tvUserMail.setText(userMail);
        } else {

            tvUserBirthDate.setText(savedInstanceState.getString(USER_BIRTH_DATE));
            tvUserMail.setText(savedInstanceState.getString(USER_MAIL));
            tvUserName.setText(savedInstanceState.getString(USER_NAME));
        }

        btnInfoEdit.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(USER_MAIL, tvUserMail.getText().toString());
        outState.putString(USER_NAME, tvUserName.getText().toString());
        outState.putString(USER_BIRTH_DATE, tvUserBirthDate.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        tvUserMail.setText(savedInstanceState.getString(USER_MAIL));
        tvUserName.setText(savedInstanceState.getString(USER_NAME));
        tvUserBirthDate.setText(savedInstanceState.getString(USER_BIRTH_DATE));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, UserInfoEditActivity.class);
        intent.putExtra("userName", tvUserName.getText().toString());
        intent.putExtra("userBirthDate", tvUserBirthDate.getText().toString());
        intent.putExtra("userMail", tvUserMail.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE:
                    tvUserName.setText(data.getStringExtra("userName"));
                    tvUserBirthDate.setText(data.getStringExtra("userBirthDate"));
                    tvUserMail.setText(data.getStringExtra("userMail"));
                    break;
            }
            Toast.makeText(this, "Успешно сохранено", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Изменения не сохранены", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}