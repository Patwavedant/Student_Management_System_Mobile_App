package com.example.harshit.sms1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 *
 */

public class FaqQueAnsActivity extends AppCompatActivity {

    TextView tv_que;
    TextView tv_ans;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq_qa);

        tv_que = findViewById(R.id.tv_que);
        tv_ans = findViewById(R.id.tv_ans);

        Intent ii = getIntent();
        if(ii.hasExtra("que"))
        {
            tv_que.setText(ii.getStringExtra("que"));
        }
    }
}
