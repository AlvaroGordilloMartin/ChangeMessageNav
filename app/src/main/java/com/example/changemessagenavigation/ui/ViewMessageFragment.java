package com.example.changemessagenavigation.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.changemessagenavigation.R;
import com.example.changemessagenavigation.model.Message;


public class ViewMessageFragment extends Fragment {

    public static final String TAG = "ViewMessageFragment";
    private TextView tvMessage;

    public ViewMessageFragment() {
        // Required empty public constructor
    }

    public static ViewMessageFragment newInstance(Bundle bundle) {
        ViewMessageFragment v = new ViewMessageFragment();
        if (bundle != null) {
            v.setArguments(bundle);

        }
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "ViewMessageFragment: onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        Log.i(TAG, "ViewMessageFragment: onCreatedView()");
        return inflater.inflate(R.layout.fragment_view_message, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvMessage=view.findViewById(R.id.tvMessage);
        Bundle bundle = getArguments();
        //Tenemos que comprobar si el objeto tiene valores
        if(bundle!=null){
            //Actualizamos el texto y el tamaño
            Message mesage =(Message) bundle.getSerializable("message");
            tvMessage.setText(mesage.getMessage());
            tvMessage.setTextSize(mesage.getSize());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "ViewMessageFragment: onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "ViewMessageFragment: onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "ViewMessageFragment: onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "ViewMessageFragment: onStop()");
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ViewMessageFragment: onDestroy()");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "ViewMessageFragment: onAttach()");

    }
}