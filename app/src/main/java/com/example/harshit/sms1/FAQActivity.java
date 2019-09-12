package com.example.harshit.sms1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FAQActivity extends AppCompatActivity {

    ListView faqlv;
    ArrayList<String> al = new ArrayList<>();
    ArrayAdapter<String> aa = null;
    String que = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq);


        //TextView tv = findViewById(R.id.ques);

        for(int i=0;i<5;i++) {

            switch(i)
            {
                case 0:
                    //tv.setText("Question "+(i+0));
                    que = "What is your college?";
                    al.add(que);
                    break;
                case 1:
                    //tv.setText("Question "+(i+0));
                    que = "What is your college?";
                    al.add(que);
                    break;
                case 2:
                    //tv.setText("Question "+(i+0));
                    que = "What is your college?";
                    al.add(que);
                    break;
                default:
                    al.add("Question ::  " + i);
            }

        }
        faqlv = findViewById(R.id.efaq);
        aa = new ArrayAdapter<String>(this, R.layout.faqquestlist, R.id.questxt, al );
        faqlv.setAdapter(aa);

        faqlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent ii = new Intent(FAQActivity.this,FaqQueAnsActivity.class);
                ii.putExtra("que", que);
                startActivity(ii);
            }
        });

    }



}
