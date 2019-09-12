package com.example.harshit.sms1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import Utility.HttpManager;
import Utility.RequestPackage;

public class ExamScheduleActivity extends AppCompatActivity {

    Button btnos;
    private View layout;
    String un, pw;
    TextView tvsem, tvdep, tvpublish;
String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examschedule);

        btnos= findViewById(R.id.os);
        layout = findViewById(R.id.esl);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        un = sp.getString("un","");
        pw = sp.getString("pw","");

        tvsem = (TextView) findViewById(R.id.tvs);
        tvdep = (TextView) findViewById(R.id.tvd);
        tvpublish = (TextView) findViewById(R.id.tvpd);

        WebTask wt = new WebTask();
        wt.execute();

        btnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                downloadFile();
                Snackbar snackbar = Snackbar.make(layout, "Your file has been downloaded", Snackbar.LENGTH_LONG);
                snackbar.setAction("View", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Write the code to view downloaded file
                        Toast.makeText(ExamScheduleActivity.this, "Viewed!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();


            }
        });
    }

    private void downloadFile() {
        String url = HttpManager.DOC_URL+filename;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    private class WebTask extends AsyncTask<String,String,String> {

        private String url = HttpManager.GLOBAL_URL + "GetExamSchedule";
        private ProgressDialog pd = null;

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
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(ExamScheduleActivity.this);
            pd.setTitle("Verifying...");
            pd.setMessage("Please wait");
            pd.setIndeterminate(true);
            pd.setCancelable(false);
            pd.show();
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

                if (jObj.has("Semester"))
                    tvsem.setText(jObj.getString("Semester").toString());
                if (jObj.has("DName"))
                    tvdep.setText( jObj.getString("DName").toString());
                if (jObj.has("PublishDate"))
                    tvpublish.setText( jObj.getString("PublishDate").toString().split("#")[0]);

                filename  = jObj.getString("ScheduleFile");
                            }

            catch (Exception e  )
            {
                e.printStackTrace();
                return;
            }
        }
    }

}
