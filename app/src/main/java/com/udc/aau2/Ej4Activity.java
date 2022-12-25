package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import com.udc.aau2.ejercicios.Ej4;

public class Ej4Activity extends AppCompatActivity {
    EditText compra;
    Button agregarCompra, calcular;
    TableLayout tableCompra;
    Ej4 ej4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);

        compra = findViewById(R.id.compra);
        agregarCompra = findViewById(R.id.btnAgregarCompra);
        calcular = findViewById(R.id.btnCalcCompra);
        tableCompra = findViewById(R.id.listaCompras);
        ej4 = new Ej4();


    }
}