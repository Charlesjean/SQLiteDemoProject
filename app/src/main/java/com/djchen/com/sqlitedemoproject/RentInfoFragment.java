package com.djchen.com.sqlitedemoproject;

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
public class RentInfoFragment extends Fragment {

    private EditText mStudentId;
    private EditText mBookId;
    private Button mDateBtn;
    private Button mSubmitBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.fragment_rent_info, container, false);
        mStudentId = (EditText)view.findViewById(R.id.input_rent_student_id);
        mBookId = (EditText)view.findViewById(R.id.input_rent_book_id);
        mDateBtn = (Button)view.findViewById(R.id.input_rent_date);
        mSubmitBtn = (Button)view.findViewById(R.id.rent_submit);
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRentInfo();
            }
        });
        return view;
    }

    private void  submitRentInfo() {
        String studentId = mStudentId.getText().toString();
        String bookId = mBookId.getText().toString();
        String rentDate = mDateBtn.getText().toString();
        //TODO need to write info to database, and clean fields
        ((MainActivity)this.getActivity()).getDatabase().addNewRentInfo(studentId, bookId, rentDate);
    }
}
