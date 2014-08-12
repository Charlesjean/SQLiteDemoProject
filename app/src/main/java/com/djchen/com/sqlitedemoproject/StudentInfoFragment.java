package com.djchen.com.sqlitedemoproject;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Duanjin Chen on 2014/8/10.
 */
public class StudentInfoFragment extends Fragment {

    private EditText mStudentId;
    private EditText mStudentName;
    private EditText mStudentTel;
    private Button mSubmitBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_student_info, container, false);
        mStudentId = (EditText)view.findViewById(R.id.input_student_id);
        mStudentName = (EditText)view.findViewById(R.id.input_student_name);
        mStudentTel = (EditText)view.findViewById(R.id.input_student_tel);
        mSubmitBtn = (Button)view.findViewById(R.id.student_submit);
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitStudentInfo();
            }
        });
        return view;
    }

    private void submitStudentInfo() {
        String id = mStudentId.getText().toString();
        String name = mStudentName.getText().toString();
        String tel = mStudentTel.getText().toString();
        //TODO need to write this to database, and clean all fields
        ((MainActivity)this.getActivity()).getDatabase().addNewStudentInfo(id,name,tel);
    }

}
