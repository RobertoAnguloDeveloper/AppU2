package com.udc.aau2.ui.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.udc.aau2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ej2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ej2Fragment extends Fragment {
    ImageView imageView;
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
        imageView = view.findViewById(R.id.dice);

        AnimationDrawable animationDrawable = new AnimationDrawable();
        int [] dices = {R.drawable.d1, R.drawable.d2, R.drawable.d3
                , R.drawable.d4, R.drawable.d5, R.drawable.d6};
        animationDrawable.addFrame(getResources().getDrawable(dices[0]), 500);
        animationDrawable.addFrame(getResources().getDrawable(dices[1]), 500);
        animationDrawable.addFrame(getResources().getDrawable(dices[2]), 500);
        animationDrawable.addFrame(getResources().getDrawable(dices[3]), 500);
        animationDrawable.addFrame(getResources().getDrawable(dices[4]), 500);
        animationDrawable.addFrame(getResources().getDrawable(dices[5]), 500);

        imageView.setImageDrawable(animationDrawable);
        animationDrawable.start();
        return view;
    }
}