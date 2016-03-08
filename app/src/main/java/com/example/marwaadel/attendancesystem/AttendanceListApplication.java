package com.example.marwaadel.attendancesystem;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.example.marwaadel.attendancesystem.utils.Constants;
import com.firebase.client.Firebase;

import java.util.List;
import java.util.UUID;

/**
 * Includes one-time initialization of Firebase related code
 */
public class AttendanceListApplication extends android.app.Application {
    private BeaconManager beaconManager;


    @Override
    public void onCreate() {
        super.onCreate();
   /* Initialize Firebase */
        Firebase.setAndroidContext(this);
        /*Beacon code*/
        beaconManager = new BeaconManager(getApplicationContext());
//        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
//            @Override
//            public void onServiceReady() {
//                beaconManager.startMonitoring(new Region
//                        (
//                                "monitored region",
//                                UUID.fromString("77b3670e-454b-434d-8445-787cc0e1ffb8"),
//                                19755, 3891 ));
//            }
//        });

//        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener()
//        {
//
//            @Override
//            public void onEnteredRegion(Region region, List<Beacon> list)
//            {
//                Toast.makeText(getApplicationContext(), "Enter", Toast.LENGTH_LONG).show();
//                // Get the reference to the root node in Firebase
//                         Firebase ref = new Firebase(Constants.FIREBASE_URL);
//                         // Get the string that the user entered into the EditText
//                        // String userEnteredName = mEditTextListName.getText().toString();
//                         // Go to the "listName" child node of the root node.
//                         // This will create the node for you if it doesn't already exist.
//                         // Then using the setValue menu it will set value the node to userEnteredName.
//                        ref.child("listName").setValue("teesst");
//
//            }
//            @Override
//            public void onExitedRegion(Region region)
//            {
//                Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_LONG).show();
//            }
//        });
    }

}