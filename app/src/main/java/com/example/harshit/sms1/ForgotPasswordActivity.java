package com.example.harshit.sms1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button btnchpss;
    EditText   btnopss, btnnpss, btncpss;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    private void btnchpss()
    {
        String oldpassword = btnopss.getText().toString().trim();
        String newpassword = btnnpss.getText().toString().trim();
        String confirmpassword = btncpss.getText().toString().trim();

        if (oldpassword.equals("aa") && newpassword.equals("abc") && confirmpassword.equals("abc"))
        {
            Toast.makeText(this, "Your Password Matched",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ForgotPasswordActivity.this, StudentHomeActivity.class));

        }
        else
        {
            Toast.makeText(this, "Your Password didn't Matched, Sorry" ,Toast.LENGTH_SHORT).show();
        }
    }
}
