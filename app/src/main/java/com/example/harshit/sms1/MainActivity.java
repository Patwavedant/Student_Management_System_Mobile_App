package com.example.harshit.sms1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT;
    SharedPreferences sf;
    Boolean ft;

    static {
        SPLASH_TIME_OUT = 1000;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sf = getSharedPreferences("Only for Once", MODE_PRIVATE);

        ft = sf.getBoolean("Once", true);

        if (ft) {

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    SharedPreferences.Editor ed = sf.edit();
                    ft = false;
                    ed.putBoolean("Only Once", ft);

                    Intent HomeIntent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(HomeIntent);

                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
        else
        {
            Intent HomeIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(HomeIntent);
            finish();

        }
    }

}
