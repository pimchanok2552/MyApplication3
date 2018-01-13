package com.example.lab3201_00.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab3201_00.myapplication.MainActivity;
import com.example.lab3201_00.myapplication.R;

/**
 * Created by LAB3201_00 on 13/1/2561.
 */

public class CalculateFragment extends Fragment {

    private double aDouble;


    public static CalculateFragment calculateInstance(double factorDouble) {

        CalculateFragment calculateFragment =new CalculateFragment();
        Bundle bundle =new Bundle();
        bundle.putDouble("Factor",factorDouble);
        calculateFragment.setArguments(bundle);

        return calculateFragment;
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Toolber Controller
        toolberController();

//         Get Valus From Argument
        aDouble =getArguments().getDouble("Factor");
        Log.d("13Jan","Factor ==>"+aDouble);


    }   //Main Method

    private void toolberController() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarCalculate);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.th_exchange));
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.th_sub_exchange));

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_calculate,container,false);
        return view;
    }
} //Main Class
