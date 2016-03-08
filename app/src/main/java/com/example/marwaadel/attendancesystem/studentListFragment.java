package com.example.marwaadel.attendancesystem;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.marwaadel.attendancesystem.model.Student;
import com.example.marwaadel.attendancesystem.utils.Constants;
import com.firebase.client.Firebase;

/**
 * A placeholder fragment containing a simple view.
 */
public class studentListFragment extends Fragment {
    ListView list;
    StudentAdapter mStudentListAdapter;
    public studentListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_student_list, container, false);
        list=(ListView)rootView.findViewById(R.id.list_view_student_lists);

        Firebase refListName = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIST);
        mStudentListAdapter = new StudentAdapter(getActivity(), Student.class,
                R.layout.list_item, refListName);

        list.setAdapter(mStudentListAdapter);

        return rootView;
    }
}
