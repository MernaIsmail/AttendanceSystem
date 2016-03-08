package com.example.marwaadel.attendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.example.marwaadel.attendancesystem.model.Student;
import com.example.marwaadel.attendancesystem.utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ServerValue;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
   private  BeaconManager beaconManager;
   // TextView mTextViewListName;
    Button Btn;
  //  ListView l;

   private StudentAdapter mStudentListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextViewListName=(TextView)findViewById(R.id.textr);
      //  l=(ListView)findViewById(R.id.list_view_student_lists);


        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(new Region
                        (
                                "monitored region",
                                UUID.fromString("77b3670e-454b-434d-8445-787cc0e1ffb8"),
                                19755, 3891));
            }
        });
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {

            @Override
            public void onEnteredRegion(Region region, List<Beacon> list) {
                Toast.makeText(getApplicationContext(), "Enter", Toast.LENGTH_LONG).show();
                // Get the reference to the root node in Firebase

                Firebase listsRef = new Firebase(Constants.FIREBASE_URL).child("StudentList");
                Firebase newListRef = listsRef.push();

                /* Save listsRef.push() to maintain same random Id */
                final String listId = newListRef.getKey();

                HashMap<String, Object> timestampCreated = new HashMap<>();
                timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);
                Student NewStudent = new Student("123", "merna", "ture", "false", timestampCreated);
                newListRef.setValue(NewStudent);

//                Firebase ref = new Firebase(Constants.FIREBASE_URL);
//                // Get the string that the user entered into the EditText
//                // String userEnteredName = mEditTextListName.getText().toString();
//                // Go to the "listName" child node of the root node.
//                // This will create the node for you if it doesn't already exist.
//                // Then using the setValue menu it will set value the node to userEnteredName.
//                ref.child("listName").setValue("teesst1");

            }

            @Override
            public void onExitedRegion(Region region) {
                Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_LONG).show();
            }
        });


        Btn=(Button) findViewById(R.id.btn);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),studentList.class);
                startActivity(intent);
            }
        });



        //Firebase refListName = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIST);


        /**
         * Add ValueEventListeners to Firebase references
         * to control get data and control behavior and visibility of elements
         */
//        refListName.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // You can get the text using getValue. Since the DataSnapshot is of the exact
//                // data you asked for (the node listName), when you use getValue you know it
//                // will return a String.
//                String listName = (String) dataSnapshot.getValue();
//                // Now take the TextView for the list name
//                // and set it's value to listName.
//                mTextViewListName.setText(listName);
//            }


//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//
//            }
//        });
//        mStudentListAdapter = new StudentAdapter(MainActivity.this, Student.class,
//         R.layout.list_item, refListName);
//
//        l.setAdapter(mStudentListAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStudentListAdapter.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
