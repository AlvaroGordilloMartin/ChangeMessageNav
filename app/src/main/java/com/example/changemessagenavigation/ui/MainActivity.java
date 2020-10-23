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
 * @author Juanjo Lago Sanchez
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity implements  SendMessageFragment.ShowMessageListener{

    private static final String TAG = "SendMessageActivity";
    private Fragment sendMessageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "SendMessage: onCreate()");
        //Se comprueba si el fragment existe o no, cuando hay un cambio de configuracion
        //Se ouede realizar de dos formas

        //1.- Si la actividad no viene de un cambio de configuracion savedInstanceState==null
        /*if (savedInstanceState==null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            SendMessageFragment fragment = new SendMessageFragment();
            ft.add(R.id.content, fragment, SendMessageFragment.TAG);
            ft.commit();
        }*/

        //2.- Buscar el fragment en el FragmentManager a traves del TAG

        FragmentManager fm = getSupportFragmentManager();
        sendMessageFragment = fm.findFragmentByTag(SendMessageFragment.TAG);
        if(sendMessageFragment==null){
            FragmentTransaction ft = fm.beginTransaction();
            sendMessageFragment= new SendMessageFragment();
            ft.add(R.id.content, sendMessageFragment, SendMessageFragment.TAG);
            ft.commit();
        }


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

    /**
     * Metodo de la interfaz SendMessageFragment.ShowMessage
     * @param message
     */
    @Override
    public void showMessage(Message message) {
        Toast.makeText(this,"Mensaje"+message.toString(),Toast.LENGTH_LONG).show();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //ViewMessageFragment fragment = new ViewMessageFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("message",message);

        //Se utiliza el metodo estatico de inicializacion newInstance de la clase Fragment
        ViewMessageFragment fragment = ViewMessageFragment.newInstance(bundle);
        //fragment.setArguments(bundle);
        ft.replace(R.id.content, fragment, ViewMessageFragment.TAG);
        //Antes de hacer commit guardamos la transaccion para cuando se pulse atras poder volver al estado anterior
        ft.addToBackStack(null);
        ft.commit();
    }
    //endregion



}
