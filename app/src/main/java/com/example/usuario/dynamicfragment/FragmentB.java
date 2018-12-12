package com.example.usuario.dynamicfragment;

import android.icu.util.BuddhistCalendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class FragmentB extends Fragment
{

    public static final String TAG = "fragmentb";
    TextView txvMessage;


    /**
     * Patrón FACTORY: Simplificación del Patrón Builder
     * Esto se debe a que setArguments debe ser llamado inmediatamente
     * después de la creación de un Fragment
     *
     * @param bundle
     * @return
     */
    public static Fragment newInstance(Bundle bundle)
    {
        FragmentB f = new FragmentB();
        if (bundle != null)
            f.setArguments(bundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmentb,container,false);
        if (rootView != null)
            txvMessage = rootView.findViewById(R.id.txvMessage);

        return  rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Recogemos los argumentos
        Bundle bundle = getArguments();
        if (bundle!= null)
        {
            //Si hay argumentos
            txvMessage.setText(bundle.getString("message"));
            txvMessage.setTextSize(bundle.getInt("size"));
        }
    }
}
