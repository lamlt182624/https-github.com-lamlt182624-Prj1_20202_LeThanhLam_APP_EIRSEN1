package com.airsen.button.ui;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airsen.button.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;



public class NewUrlActivity extends AppCompatActivity {
    EditText edtType, edtTime, edtTittle, edtContent, edtUrl;
    Button btnSendNewUrl;
    //String url = "http://192.168.1.183/AirMapDatabase/UrlInformation/insertUrl.php"; //home
    //String url = "http://192.168.11.3/AirMapDatabase/UrlInformation/insertUrl.php"; //wifi sparclab2
    String url = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=lamurl&table=url&pos=0"; // rount sparclab2
//    String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_url);
        edtType = findViewById(R.id.edt_new_url_type_developer);
        edtTime = findViewById(R.id.edt_new_url_time_developer);
        edtTittle = findViewById(R.id.edt_new_url_tittle_developer);
        edtContent = findViewById(R.id.edt_new_url_content_developer);
        edtUrl = findViewById(R.id.edt_new_url_url_developer);
        btnSendNewUrl = findViewById(R.id.btn_new_url_send_developer);

        btnSendNewUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUrl(url);
            }
        });
    }

    private void insertUrl(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            Toast.makeText(NewUrlActivity.this, "success", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(NewUrlActivity.this, "Fail", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("Type", edtType.getText().toString().trim());
                param.put("Time", edtTime.getText().toString().trim());
                param.put("Tittle", edtTittle.getText().toString().trim());
                param.put("Content", edtContent.getText().toString().trim());
                param.put("Url", edtUrl.getText().toString().trim());
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

}
