package com.example.dsm_025.whatinconveniencestore.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dsm_025.whatinconveniencestore.R;

/**
 * Created by dsm_025 on 2017-07-03.
 */

public class FoodInformationDialogFragment extends DialogFragment {
    private MyDialogListener myListener;
    private TextView nameTextView;
    private TextView writerTextView;
    private TextView priceTextView;
    private ImageView foodImageView;


    public interface MyDialogListener {
        public void myCallback(String cityName);
    }

    public FoodInformationDialogFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

//            priceTextView.setText(arg.getString("price"));

        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.fragment_foodinfo, null);
        builder.setView(rootView)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });

        myListener = (MyDialogListener) getTargetFragment();
        nameTextView = (TextView) rootView.findViewById(R.id.textview_name);
        writerTextView = (TextView) rootView.findViewById(R.id.textview_writer);
        priceTextView = (TextView) rootView.findViewById(R.id.textview_price);
        foodImageView = (ImageView) rootView.findViewById(R.id.imageview_food);

        Bundle arg = getArguments();
        nameTextView.setText(arg.getString("name"));
        writerTextView.append(arg.getString("writer"));
        priceTextView.append(arg.getString("price"));

        return builder.create();
    }
}
