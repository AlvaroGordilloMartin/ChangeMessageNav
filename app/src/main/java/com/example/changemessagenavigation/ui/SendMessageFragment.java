package com.example.changemessagenavigation.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.changemessagenavigation.ChangeMessageAplication;
import com.example.changemessagenavigation.R;
import com.example.changemessagenavigation.model.Message;

import java.util.Random;

public class SendMessageFragment extends Fragment {

    public static final String TAG = "SendMessageFragment";
    private Button btSendMessage;
    private EditText edMessage;
    private Button btAbout;
    private SeekBar skSize;
    private ShowMessageListener callback;

    //Atributo de instancia que no pertenece al diseño
    private int number;

    public interface ShowMessageListener{
        void showMessage(Message message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {

            callback = (ShowMessageListener)context;
        }catch (ClassCastException e){
            throw  new ClassCastException(getActivity().toString()+"must implement ShowMessageListener");
        }

        Log.i(TAG, "SendMessageFragment: onAttach()");
    }

    public SendMessageFragment() {
        // Required empty public constructor


    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "SendMessageFragment: onCreate()");
        setRetainInstance(true);
        number= new Random().nextInt(101);
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_message, container, false);


        return view;


    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btSendMessage=view.findViewById(R.id.btSendMessage);
        edMessage=view.findViewById(R.id.edMessage);
        skSize=view.findViewById(R.id.skSize);
        btAbout=view.findViewById(R.id.btAbout);
        Toast.makeText(getActivity(),"Numero Generado:"+number,Toast.LENGTH_SHORT).show();
        btSendMessage.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //1. Crear un objeto contenedor o bundle para añadir los datos
                Bundle bundle = new Bundle();
                //bundle.putString("message", edMessage.getText().toString());
                //bundle.putInt("size", skSize.getProgress());
                //1.1 crear objeto message
                Message message = new Message(((ChangeMessageAplication) getActivity().getApplication()).getUser(),
                        edMessage.getText().toString(), "16/10/2020", skSize.getProgress());
                callback.showMessage(message);
            }
        });
        btAbout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showAbout((view));
            }
        });

        Log.i(TAG, "SendMessageFragment: onViewCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "SendMessageFragment: onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "SendMessageFragment: onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "SendMessageFragment: onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "SendMessageFragment: onStop()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "SendMessageFragment: onSaveInstanceState()");

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(TAG, "SendMessageFragment: onViewStateRestored()");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "SendMessageFragment: onDestroy()");
    }



        /**
         * Método que se ejecuta cuando se pulsa el btAbout
         * se ha implementado mediante el atributo android:onclick en
         * activity_main.
         * @param view botón donde se ha realizado click.
         */
        public void showAbout(View view){
            Intent intent= new Intent(getActivity(), AboutActivity.class);
            startActivity(intent);
        }
    }
