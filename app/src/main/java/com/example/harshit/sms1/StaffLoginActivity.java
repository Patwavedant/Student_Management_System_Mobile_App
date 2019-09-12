package com.example.harshit.sms1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StaffLoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView btnfpss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stafflogin);

        btnfpss= findViewById(R.id.sfpss);
        btnfpss.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sfpss)
        {
            startActivity(new Intent(StaffLoginActivity.this, ForgotPasswordActivity.class));
            finish();
        }
    }
}
