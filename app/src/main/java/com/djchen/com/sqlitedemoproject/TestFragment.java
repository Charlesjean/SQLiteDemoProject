package com.djchen.com.sqlitedemoproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2014/8/11.
 */
public class TestFragment extends Fragment {

    private Button mbtn;
    private TextView mtext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query_test, container,false);
        mbtn = (Button)view.findViewById(R.id.test_btn);
        mtext = (TextView)view.findViewById(R.id.test_sql);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestDatabase();
            }
        });
        return view;
    }

    private void TestDatabase() {
        ((MainActivity)getActivity()).getDatabase().Test();
        getActivity().deleteDatabase("library");
    }
}

