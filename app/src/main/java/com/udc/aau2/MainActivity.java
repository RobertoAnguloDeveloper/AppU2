package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.udc.aau2.ui.fragments.Ej1Fragment;
import com.udc.aau2.ui.fragments.Ej2Fragment;
import com.udc.aau2.ui.fragments.Ej3Fragment;
import com.udc.aau2.ui.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment homeFragment, ej1Fragment, ej2Fragment, ej3Fragment;
    Intent intentEj4, intentEj5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.splash_screen_theme);
        setTheme(R.style.Theme_AAU2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        ej1Fragment = new Ej1Fragment();
        ej2Fragment = new Ej2Fragment();
        ej3Fragment = new Ej3Fragment();
        intentEj4 = new Intent(this, Ej4Activity.class);
        intentEj5 = new Intent(this, Ej5Activity.class);

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

            case R.id.btnEj4: startActivity(intentEj4);
                break;

            case R.id.btnEj5: startActivity(intentEj5);
                break;
        }
    }

}