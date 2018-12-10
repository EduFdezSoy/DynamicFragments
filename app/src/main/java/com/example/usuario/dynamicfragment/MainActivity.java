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

    @Override
    public void onTextSizeChanged(String message, int size) {

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
