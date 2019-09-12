package com.example.harshit.sms1;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TimeTableActivity extends AppCompatActivity {

    Button btntt;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);

        btntt= findViewById(R.id.ott);
        layout= findViewById(R.id.ttl);

        btntt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntt();
                Snackbar snackbar = Snackbar.make(layout, "Your file has been downloaded", Snackbar.LENGTH_LONG);
                snackbar.setAction("View", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Write the code to view downloaded file
                        Toast.makeText(TimeTableActivity.this, "Viewed!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();

            }
        });
    }

    private void btntt() {
    }
}
