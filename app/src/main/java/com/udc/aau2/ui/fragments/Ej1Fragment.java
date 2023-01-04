package com.udc.aau2.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.udc.aau2.R;
import com.udc.aau2.ejercicios.Ej1;
import com.udc.aau2.ejercicios.Validador;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ej1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ej1Fragment extends Fragment {
    private Button btnCalcular;
    private EditText n;
    private TextView resultado;
    private Ej1 ej1;
    private View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Ej1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ej1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Ej1Fragment newInstance(String param1, String param2) {
        Ej1Fragment fragment = new Ej1Fragment();
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
        view = inflater.inflate(R.layout.fragment_ej1, container, false);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        resultado = view.findViewById(R.id.resultadoEj1);

        n = view.findViewById(R.id.n);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ej1 =  new Ej1();
                if(!n.getText().toString().isEmpty()){
                    Integer num = Integer.parseInt(String.valueOf(n.getText()));
                    Integer result = ej1.calcularCubo(num);
                    resultado.setText(result+"");
                    String respuesta = ej1.eresAfortunado(result);

                    if(!respuesta.isEmpty()){
                        Toast.makeText(getContext(),respuesta, Toast.LENGTH_LONG).show();
                    }
                    Validador.limpiarCampos(n);
                }
            }
        });
        return view;
    }
}