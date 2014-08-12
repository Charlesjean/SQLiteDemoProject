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
public class BookInfoFragment extends Fragment {

    private EditText mBookId;
    private EditText mBookName;
    private EditText mBookPrice;
    private Button mSubmitBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_book_info, container, false);
        mBookId = (EditText)view.findViewById(R.id.input_book_id);
        mBookName = (EditText)view.findViewById(R.id.input_book_name);
        mBookPrice = (EditText)view.findViewById(R.id.input_book_price);
        mSubmitBtn = (Button)view.findViewById(R.id.book_submit);
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitBookInfo();
            }
        });

        return view;
    }

    private void submitBookInfo() {
        String id = mBookId.getText().toString();
        String name = mBookName.getText().toString();
        double price = Double.parseDouble(mBookPrice.getText().toString());
        //TODO need to add this info to database, and clean fields
        ((MainActivity)this.getActivity()).getDatabase().addNewBookInfo(id, name, price);
    }
}
