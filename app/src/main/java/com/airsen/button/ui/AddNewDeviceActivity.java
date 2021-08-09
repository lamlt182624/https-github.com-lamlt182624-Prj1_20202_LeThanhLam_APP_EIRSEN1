package com.airsen.button.ui;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.airsen.button.R;


public class AddNewDeviceActivity extends AppCompatActivity {
    Button btnLogOut, btnDevice, btnLocation, btnUser, btnCalibration, btnMessage, btnUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_developer);


        btnLogOut = findViewById(R.id.btn_logout_developer);
        btnDevice = findViewById(R.id.btn_new_device_developer);
        btnLocation = findViewById(R.id.btn_new_location_developer);
        btnUser = findViewById(R.id.btn_new_user_developer);
        btnCalibration = findViewById(R.id.btn_new_calibration_developer);
        btnMessage = findViewById(R.id.btn_new_message_developer);
        btnUrl = findViewById(R.id.btn_new_url_developer);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCalibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewDeviceActivity.this,NewUrlActivity.class);
                startActivity(intent);
            }
        });

    }
}
