package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.udc.aau2.ejercicios.Ej1;
import com.udc.aau2.ui.fragments.Ej1Fragment;
import com.udc.aau2.ui.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment homeFragment, ejercicio1Frag;
    Ej1 ej1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        ejercicio1Frag = new Ej1Fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentFrame, homeFragment).commit();
    }

    public void onClick(View view){
        transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btnEj1: transaction.replace(R.id.fragmentFrame, ejercicio1Frag).commit();

                break;
            case R.id.btnCalcular:
                System.out.println("ENTRO");;
                break;
        }
    }

}