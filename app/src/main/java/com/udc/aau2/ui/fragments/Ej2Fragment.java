package com.udc.aau2.ui.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.udc.aau2.R;
import com.udc.aau2.ejercicios.Ej1;
import com.udc.aau2.ejercicios.Ej2;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ej2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ej2Fragment extends Fragment {
    private ImageView imageView1, imageView2;
    private Button btnTirarDados;
    private Ej2 ej2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Ej2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ej2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Ej2Fragment newInstance(String param1, String param2) {
        Ej2Fragment fragment = new Ej2Fragment();
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
        View view = inflater.inflate(R.layout.fragment_ej2, container, false);
        imageView1 = view.findViewById(R.id.dice1);
        imageView2 = view.findViewById(R.id.dice2);
        btnTirarDados = view.findViewById(R.id.btnTirarDados);

        int [] dices = {R.drawable.d1, R.drawable.d2, R.drawable.d3
                , R.drawable.d4, R.drawable.d5, R.drawable.d6};

        AnimationDrawable animationDrawable1 = new AnimationDrawable();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();

        btnTirarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ej2 =  new Ej2();

                if(animationDrawable1.isRunning()){
                    animationDrawable1.stop();
                    animationDrawable2.stop();
                }else{
                    for (int i = 0; i < dices.length; i++) {
                        animationDrawable1.addFrame(getResources().getDrawable(dices[ej2.randomId(dices)]), ej2.randomTime());
                        animationDrawable2.addFrame(getResources().getDrawable(dices[ej2.randomId(dices)]), ej2.randomTime());
                    }

                    imageView1.setImageDrawable(animationDrawable1);
                    animationDrawable1.start();
                    imageView2.setImageDrawable(animationDrawable2);
                    animationDrawable2.start();
                }
            }
        });
        return view;
    }
}