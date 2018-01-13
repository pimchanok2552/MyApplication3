package com.example.lab3201_00.myapplication.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
        getValueFromArgument();

//        Calculate Controller
        calculateController();


    }   //Main Method

    private void calculateController() {
        Button button =getView().findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Get Value From EditText
                EditText editText =getView().findViewById(R.id.edtMoney);
                String moneyString =editText.getText().toString().trim();

//                Check Space
                if (moneyString.isEmpty()){
//                    Have Space
                    myAlert("Have Space","please Fill Money in Blank");

                }else {
//                    No Space

                    double moneyDouble =Double.parseDouble(moneyString);
                    double answerDouble =moneyDouble*aDouble;
                    String answerString ="Thai Baht ==>"+Double.toString(answerDouble)+"THB";
                    myAlert("Your"+moneyString+"USD",answerString);
                    editText.setTag("");

                } //if

            } //onClick
        });


    }

    private void myAlert(String titleString, String messageString) {

        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(titleString);
        builder.setMessage(messageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();

    } //myAlert

    private void getValueFromArgument() {
        aDouble =getArguments().getDouble("Factor");
        Log.d("13Jan","Factor ==>"+aDouble);
    }

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
