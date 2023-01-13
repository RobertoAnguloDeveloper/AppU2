package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.udc.aau2.ui.fragments.Ej1Fragment;
import com.udc.aau2.ui.fragments.Ej2Fragment;
import com.udc.aau2.ui.fragments.Ej3Fragment;
import com.udc.aau2.ui.fragments.HomeFragment;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction transaction;
    private Fragment homeFragment, ej1Fragment, ej2Fragment, ej3Fragment;
    private Intent intentEj4, intentEj5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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