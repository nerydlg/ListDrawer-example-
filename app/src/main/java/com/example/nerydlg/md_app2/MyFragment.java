package com.example.nerydlg.md_app2;

import android.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by nerydlg on 1/03/16.
 */
public class MyFragment extends Fragment{

    public static final String ARGS_COLOR = "ARGS_COLOR";
    public static final String SUBTITLE   = "SUBTITLE";
    private OnFragmentInteractionListener fmListener;

    public static MyFragment getInstance(int color, String subtitle){

       MyFragment fragment = new MyFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_COLOR, color);
        bundle.putString(SUBTITLE, subtitle);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        int color = getArguments().getInt(ARGS_COLOR);
        String subt = getArguments().getString(SUBTITLE);
        fmListener.onFragmentInteraction(subt);
        RelativeLayout layout = (RelativeLayout) rootView.findViewById(R.id.fragment_layout);
        layout.setBackgroundColor(color);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            fmListener = (OnFragmentInteractionListener) activity;
        }catch(ClassCastException ex){
            throw new ClassCastException(activity.toString()+
                    "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fmListener = null;
    }

    public interface OnFragmentInteractionListener{

        public void onFragmentInteraction(String strSubt);

    }
}
