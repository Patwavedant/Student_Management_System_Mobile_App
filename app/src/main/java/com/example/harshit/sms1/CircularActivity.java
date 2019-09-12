package com.example.harshit.sms1;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CircularActivity extends AppCompatActivity {

    ListView clv;

    ArrayList<String> al = new ArrayList<String>();
    ArrayAdapter<String> aa = null;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circular);

        layout = findViewById(R.id.rlay);

        for(int i=0;i<10;i++)
            al.add("Circular "+ i);

        clv = (ListView) findViewById(R.id.ecircular);
        aa = new ArrayAdapter<String>(this, R.layout.list_of_circular, R.id.lc1, al );
        clv.setAdapter(aa);

        clv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Snackbar snackbar = Snackbar.make(layout, "Your file has been downloaded", Snackbar.LENGTH_LONG);
                snackbar.setAction("View", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Write the code to view downloaded file
                        Toast.makeText(CircularActivity.this, "Viewed!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });

    }
}