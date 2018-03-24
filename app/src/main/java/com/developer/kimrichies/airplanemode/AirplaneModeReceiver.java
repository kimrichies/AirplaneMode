package com.developer.kimrichies.airplanemode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED;

public class AirplaneModeReceiver extends BroadcastReceiver {
    public AirplaneModeReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        //retrieve data from the broadcast intent
        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

        //launch the main activity intent

        Intent intent2 = new Intent(context, MainActivity.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        if(isAirplaneModeOn){
            intent.putExtra("AIRPLANE_MODE_MESSAGE", "Airplane Mode turned On");

        } else {
            intent2.putExtra("AIRPLANE_MODE_MESSAGE", "Airplane Mode turned off");
        }

        context.startActivity(intent2);


       // throw new UnsupportedOperationException("Not yet implemented");
    }
}
