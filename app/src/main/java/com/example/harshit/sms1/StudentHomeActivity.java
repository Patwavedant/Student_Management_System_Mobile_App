package com.example.harshit.sms1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentHomeActivity extends AppCompatActivity {

    Button btnmp,btnes,btntt,btnc,btnfaq,btnma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_home);

        btnmp= findViewById(R.id.mp);
        btnes= findViewById(R.id.es);
        btntt= findViewById(R.id.tt);
        btnc= findViewById(R.id.c);
        btnfaq= findViewById(R.id.faq);
        btnma= findViewById(R.id.ma);
        btnmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnmp();
                Intent i = new Intent(StudentHomeActivity.this, myprofileActivity.class);
                startActivity(i);
            }
        });
        btnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnes();
                Intent j = new Intent(StudentHomeActivity.this, ExamScheduleActivity.class);
                startActivity(j);
            }
        });
        btntt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntt();
                Intent k = new Intent(StudentHomeActivity.this, TimeTableActivity.class);
                startActivity(k);
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnc();
                Intent l = new Intent(StudentHomeActivity.this, CircularActivity.class);
                startActivity(l);
            }
        }); 
        btnfaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnfaq();
                Intent m = new Intent(StudentHomeActivity.this, FAQActivity.class);
                startActivity(m);
            }
        });
        btnma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnma();
                Intent n = new Intent(StudentHomeActivity.this, MyAttendanceActivity.class);
                startActivity(n);
            }
        });
    }

    private void btnma() {
    }

    private void btnfaq() {
    }

    private void btnc() {
    }

    private void btntt() {
    }

    private void btnes() {
    }

    private void btnmp() {
    }
}
