package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.udc.aau2.ui.Home.Ejercicio1;
import com.udc.aau2.ui.Home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment homeFragment, ejercicio1Frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        ejercicio1Frag = new Ejercicio1();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentFrame, homeFragment).commit();

        //transaction = getSupportFragmentManager().beginTransaction();
    }
}