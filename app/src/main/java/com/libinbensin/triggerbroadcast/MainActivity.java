package com.libinbensin.triggerbroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.trigger_geofence_enter_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onGeofenceEnterClicked();
                    }
                });

        findViewById(R.id.trigger_geofence_exit_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onGeofenceExitClicked();
                    }
                });
    }

    private void onGeofenceExitClicked() {
        // broadcast exit
        Intent intent = new Intent("geofence.FOUND");
        intent.putExtra("geofence.status" , 2);
        sendBroadcast(intent);
    }

    private void onGeofenceEnterClicked() {
        // broadcast enter
        Intent intent = new Intent("geofence.FOUND");
        intent.putExtra("geofence.status" , 1);
        sendBroadcast(intent);

    }
}
