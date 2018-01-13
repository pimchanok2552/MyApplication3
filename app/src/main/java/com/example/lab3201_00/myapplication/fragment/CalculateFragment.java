package com.example.lab3201_00.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab3201_00.myapplication.MainActivity;
import com.example.lab3201_00.myapplication.R;

/**
 * Created by LAB3201_00 on 13/1/2561.
 */

public class CalculateFragment extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Toolber Controller
        Toolbar toolbar = getView().findViewById(R.id.toolbarCalculate);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.th_exchange));
         ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.th_sub_exchange));

         ((MainActivity) getActivity()).getSupportActionBar().setHideOnContentScrollEnabled(true);

         toolbar.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 getActivity().getSupportFragmentManager().popBackStack();
             }
         });


    }   //Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_calculate,container,false);
        return view;
    }
} //Main Class
