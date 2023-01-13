package com.udc.aau2.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.udc.aau2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ej3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ej3Fragment extends Fragment {
    private Button btnNormal, btnAlreves;
    private EditText cadena;
    private TextView resultado;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Ej3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ej3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Ej3Fragment newInstance(String param1, String param2) {
        Ej3Fragment fragment = new Ej3Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ej3, container, false);

        cadena = view.findViewById(R.id.cadenaEj3);
        resultado = view.findViewById(R.id.resultadoEj3);
        btnNormal = view.findViewById(R.id.btnCadenaNormal);
        btnAlreves = view.findViewById(R.id.btnCadenaReves);

        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(cadena.getText());
            }
        });

        btnAlreves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = String.valueOf(cadena.getText());
                StringBuffer stringBuffer = new StringBuffer(string);
                resultado.setText(stringBuffer.reverse());
            }
        });
        return view;
    }
}