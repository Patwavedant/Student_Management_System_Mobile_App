package com.example.harshit.sms1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Utility.HttpManager;
import Utility.RequestPackage;

public class ChangePassword extends AppCompatActivity implements View.OnClickListener {

    EditText opss, npss, cpss;
    Button chpss;
    String  Password, newpw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        opss = (EditText) findViewById(R.id.edo);
        npss = (EditText) findViewById(R.id.edn);
        cpss = (EditText) findViewById(R.id.cn);
        chpss = (Button) findViewById(R.id.btncp);

        chpss.setOnClickListener(this);

        webTask wt = new webTask();
        wt.execute("http://192.168.1.5:12037/StudentService/ChangePassword");
    }

    @Override
    public void onClick(View v) {


         Password = opss.getText().toString();
         Password = npss.getText().toString();
         newpw = cpss.getText().toString();

           startActivity(new Intent (ChangePassword.this, myprofileActivity.class));
    }


    private class webTask extends AsyncTask<String, String, String>{


        ProgressDialog pd = null;
        String Username, Password, newpw;

        @Override
        protected String doInBackground(String... strings) {

            String uri = strings[0];
            RequestPackage rp = new RequestPackage();
            rp.setMethod("GET");

            rp.setParam("Username", Username);
            rp.setParam("Password", Password);
            rp.setParam("newpw", newpw);

            rp.setUri(uri);

            String ans = HttpManager.getData(rp);

            return ans;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Password = opss.getText().toString();
            Password = npss.getText().toString();
            newpw = cpss.getText().toString();

            pd = new ProgressDialog(ChangePassword.this);
            pd.setTitle("Verifying...");
            pd.setMessage("Please wait");
            pd.setIndeterminate(true);
            pd.setCancelable(false);
            pd.show();

        }

        @Override
        protected void onPostExecute(String s){



            if(pd!=null){
                pd.dismiss();
            }

            if ((npss.getText().toString()).equals(cpss.getText().toString()))
            {
                Toast.makeText(ChangePassword.this, "Password match !!!",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(ChangePassword.this,"Passwod doen't match !!! ",Toast.LENGTH_LONG).show();
            }
        }
    }

}
