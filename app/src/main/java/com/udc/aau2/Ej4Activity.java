package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.udc.aau2.ejercicios.Compra;
import com.udc.aau2.ejercicios.Ej4;

public class Ej4Activity extends AppCompatActivity {
    EditText compraEditText;
    Compra compra;
    Button agregarCompra, calcular;
    TableLayout tableCompra;
    Ej4 ej4;
    Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);

        compraEditText = findViewById(R.id.compra);
        agregarCompra = findViewById(R.id.btnAgregarCompra);
        calcular = findViewById(R.id.btnCalcCompra);
        tableCompra = findViewById(R.id.listaCompras);
        ej4 = new Ej4();
        count = 0;

        agregarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                TableRow tableRow = new TableRow(context);
                String compraString = String.valueOf(compraEditText.getText());
                if(compraString.isEmpty()){
                    compraString = "0.0";
                }
                Double comp = Double.parseDouble(compraString);
                compra = new Compra();
                compra.setCompra(comp);
                ej4.agregarALista(compra);
                TextView textView1 = new TextView(context);
                TextView textView2 = new TextView(context);

                count++;

                textView1.setText(String.valueOf(count));
                textView2.setText(String.valueOf(compra.getCompra()));

                tableRow.addView(textView1);
                tableRow.addView(textView2);

                tableCompra.addView(tableRow);

            }
        });
    }
}