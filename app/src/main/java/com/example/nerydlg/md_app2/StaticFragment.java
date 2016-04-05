package com.example.nerydlg.md_app2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nerydlg on 8/03/16.
 */
public class StaticFragment extends Fragment{

    TextView tv = null;

    public StaticFragment(){
        // here empty
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.static_fragment_layout, container, false);

        tv = (TextView) rootView.findViewById(R.id.textView);

        tv.setText("Hello Settings");

        return rootView;
    }
}
