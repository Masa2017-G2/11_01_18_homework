package com.sheygam.masa_2017_g2_11_01_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputPassword;
    private Button okBtn;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        email = getIntent().getStringExtra(MainActivity.EMAIL);
        inputPassword = findViewById(R.id.input_password);
        okBtn = findViewById(R.id.next_btn);
        okBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next_btn){
            String password = inputPassword.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(MainActivity.EMAIL,email);
            intent.putExtra(MainActivity.PASS,password);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
