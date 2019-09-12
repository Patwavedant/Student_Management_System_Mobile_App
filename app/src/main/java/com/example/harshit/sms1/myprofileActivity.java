package com.example.harshit.sms1;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import Utility.HttpManager;
import Utility.RequestPackage;

public class myprofileActivity extends AppCompatActivity {

    String un, pw;
    TextView nm, em, sm, ph, css, dpm;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprofile);

          nm = (TextView) findViewById(R.id.tvn);
          em = (TextView) findViewById(R.id.tve);
          ph = (TextView) findViewById(R.id.tvp);
          sm = (TextView) findViewById(R.id.ss);
          css = (TextView) findViewById(R.id.sc);
          dpm= (TextView) findViewById(R.id.sd);


          SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
          un = sp.getString("un","");
          pw = sp.getString("pw","");

          new JSONParse().execute();

    }

    private class JSONParse extends AsyncTask<String, String, String> {


        private  String url = HttpManager.GLOBAL_URL+ "MyProfile";

        private ProgressDialog pd = null ;


        public void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(myprofileActivity.this);
            pd.setTitle("Verifying...");
            pd.setMessage("Please wait");
            pd.setIndeterminate(true);
            pd.setCancelable(false);
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {




            RequestPackage rp = new RequestPackage();

            rp.setMethod("GET");

            rp.setParam("un", un);
            rp.setParam("pw", pw);

            rp.setUri(url);



            String ans = HttpManager.getData(rp);
            return ans.trim();

        }
    @Override
    protected void onPostExecute(String str) {

            if(pd!=null){
                pd.dismiss();
            }
        if (str == null || str.equals("")) {

            return ;
        }
        try {
            JSONArray jarr = new JSONArray(str);

            JSONObject jObj = jarr.getJSONObject(0);

            if (jObj.has("Name"))
                nm.setText(jObj.getString("Name").toString());
            if (jObj.has("Email"))
                em.setText( jObj.getString("Email").toString());
            if (jObj.has("Phone"))
                ph.setText( jObj.getString("Phone").toString());
            if (jObj.has("Semester"))
                sm.setText( jObj.getString("Semester").toString());
            if (jObj.has("Class"))
                css.setText(jObj.getString("Class").toString());
            if (jObj.has("DName"));
                dpm.setText(jObj.getString("DName").toString());
        }

        catch (Exception e  )
        {
            e.printStackTrace();
            return;
        }

    }
    }
}
