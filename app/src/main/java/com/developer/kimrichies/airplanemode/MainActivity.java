package com.developer.kimrichies.airplanemode;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.type;
import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    TextView displayMode;
    Button refresh,close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        displayMode = (TextView) findViewById(R.id.ModeView);

        //get the intent from the Airplane mode receiver class
        Intent intentSend = getIntent();
        intentSend.getExtras();


        if (intentSend.getExtras()!=null) {
            if (intentSend.getExtras().toString().equals("AIRPLANE_MODE_MESSAGE")) {

                //display Broadcasted message received");
                displayMode.setText("Airplane Mode is Off");
            }
            // else if (receiverIntent.equals(true)) {
            else {
                displayMode.setText("Broadcasted message received " + "Airplane Mode turned off");
            }

        }
        else {
            displayMode.setText("Broadcasted message received " + "Airplane Mode turned On");
        }

    }

    //The refresh button method
    public void OnRefresh(View v1){
        refresh = (Button)findViewById(R.id.Refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean airplane_mode = Settings.System.getInt(getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
                displayMode = (TextView) findViewById(R.id.ModeView);
                if (airplane_mode) {
                    displayMode.setText("Airplane mode is on");
                } else {
                    displayMode.setText("Airplane mode is off");
                }
            }
        });

    }

    //The close button method
    public void OnClose(View v2){
        close = (Button)findViewById(R.id.Close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
