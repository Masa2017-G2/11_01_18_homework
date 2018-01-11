package com.sheygam.masa_2017_g2_11_01_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PASSWORD_ACTIVITY_REQUEST = 0x01;
    private EditText inputEmail;
    private Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        inputEmail = findViewById(R.id.input_email);
        nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.next_btn){
            String email = inputEmail.getText().toString();
            Intent intent = new Intent(this,PasswordActivity.class);
            intent.putExtra(MainActivity.EMAIL,email);
            startActivityForResult(intent,PASSWORD_ACTIVITY_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == PASSWORD_ACTIVITY_REQUEST){
            setResult(RESULT_OK,data);
            finish();
        }
    }
}
