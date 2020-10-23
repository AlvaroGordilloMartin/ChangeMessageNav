package com.example.changemessagenavigation.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.changemessagenavigation.R;
import com.example.changemessagenavigation.model.Message;

/**
 * <h1>Función de la clase</h1>
 * <p>Esta clase envia un texto a otra actividad y le indica el tamaño del texto</p>
 * <h2>aprendizaje</h2>
 * <ul>
 *     <li>que es context</li>
 *     <li>que se puede introducir etiquetas HTML dentro de los comentarios javadoc </li>
 *     <li>que es un objeto {@link android.os.Bundle}</li>
 *     <li>El paso de mensajes entre dos activity mediante la clase <a target="_blank" href="https://developer.android.com/reference/android/content/Intent">Intent</a></li>
 * </ul>
 * @author Alvaro Gordillo Martitn
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "SendMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "SendMessage: onCreate()");

    }


//region Ciclo de vida del activity
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "SendMessage: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "SendMessage: onResume()");
    }

    //Callback donde se debe guardar el estado dinamico de la actividad
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "SendMessage: onSaveInstanceState()");

    }

    //Callback donde se restaura el estado dinamico de la activcidad
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "SendMessage: onRestoreInstanceState()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "SendMessage: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "SendMessage: onStop()");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "SendMessage: onDestroy()");
    }

    //endregion



}
