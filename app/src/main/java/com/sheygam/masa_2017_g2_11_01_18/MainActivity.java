package com.sheygam.masa_2017_g2_11_01_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int EMAIL_ACTIVITY_REQUEST = 0x01;

    public static final String EMAIL = "EMAIL";
    public static final String PASS = "PASSWORD";

    private TextView emailTxt, passwordTxt;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailTxt = findViewById(R.id.email_txt);
        passwordTxt = findViewById(R.id.password_txt);
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                startActivityForResult(new Intent(this,EmailActivity.class),EMAIL_ACTIVITY_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == EMAIL_ACTIVITY_REQUEST){
            String email = data.getStringExtra(EMAIL);
            String password = data.getStringExtra(PASS);
            emailTxt.setText(email);
            passwordTxt.setText(password);
        }
    }
}
