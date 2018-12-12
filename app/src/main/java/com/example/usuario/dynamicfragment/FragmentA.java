package com.example.usuario.dynamicfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class FragmentA extends Fragment
{
    public static final String TAG = "fragmenta";
    private FragmentAListener listener;
    private EditText edMessage;
    private SeekBar skSize;
    private Button btSize;

    /**
     * Se define la interfaz que será el contrato entre la Activity:
     */
    interface FragmentAListener
    {
        void onTextSizeChanged(String message, int size);
    }

    //Este método sólo funciona desde la API 23 en adelante. Si se ejecuta en una API inferior
    //NO DA ERROR, pero no funciona la comunicación Activity-Fragment (Por eso el try)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try
        {
            listener = (FragmentAListener)context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "must implement FragmentAListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenta, container, false);
        if (rootView != null) {
            edMessage = rootView.findViewById(R.id.edtMessage);
            btSize = rootView.findViewById(R.id.btnSize);
            skSize = rootView.findViewById(R.id.skSize);
        }

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hay que decir a la Activity que ha ocurrido un evento
                listener.onTextSizeChanged(edMessage.getText().toString(), skSize.getProgress());
            }
        });
        Log.d(TAG,"FragmentA:onViewCreated()");
    }
}
