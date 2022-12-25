package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.udc.aau2.ejercicios.Ej1;
import com.udc.aau2.ui.fragments.Ej1Fragment;
import com.udc.aau2.ui.fragments.Ej2Fragment;
import com.udc.aau2.ui.fragments.Ej3Fragment;
import com.udc.aau2.ui.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment homeFragment, ej1Fragment, ej2Fragment, ej3Fragment;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        ej1Fragment = new Ej1Fragment();
        ej2Fragment = new Ej2Fragment();
        ej3Fragment = new Ej3Fragment();
        intent = new Intent(this, Ej4Activity.class);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentFrame, homeFragment).commit();
    }

    public void onClick(View view){
        transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btnEj1: transaction.replace(R.id.fragmentFrame, ej1Fragment).commit();
                break;

            case R.id.btnEj2: transaction.replace(R.id.fragmentFrame, ej2Fragment).commit();
                break;

            case R.id.btnEj3: transaction.replace(R.id.fragmentFrame, ej3Fragment).commit();
                break;

            case R.id.btnEj4: startActivity(intent);
                break;
        }
    }

}