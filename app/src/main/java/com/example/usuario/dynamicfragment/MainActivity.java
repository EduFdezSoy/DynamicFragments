package com.example.usuario.dynamicfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener {

    public static final String TAG = "DynamicFragment";
    private Fragment fragmenta;
    private Fragment fragmentb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmenta = getSupportFragmentManager().findFragmentByTag(FragmentA.TAG);
        if (fragmenta == null)
        {
            fragmenta = new FragmentA();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //android.R.id.content es el id del FrameLayout de MainActivty
            fragmentTransaction.add(android.R.id.content, fragmenta, FragmentA.TAG);
            fragmentTransaction.commit();
        }
    }

    /**
     * Método que cambia el texto y tamaño del TextView del fragmentB
     * que se debe intercambiar y el fragmentA por el fragmentB
     * y además pasar los datos (message, size) al fragmentB
     *
     * @param message
     * @param size
     */
    @Override
    public void onTextSizeChanged(String message, int size) {

        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        bundle.putInt("size", size);
        //Patrón Factoría: es la propia clase quien crea un objeto
        //del FragmentB, se pasa los argumentos a sí mismo y devuelve el objeto
        fragmentb = FragmentB.newInstance(bundle);

        //Comienza el cambio del FragmentA por el FragmentB
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentb);
        //Se guardan las transacciones (no los fragments en concreto)
        //FragmentA --> FragmentB
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /**
     * Método del CICLO DE VIDA
     */

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity:onStart()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity:onStop()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity:onPause()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity:onDestroy()");

    }
}
