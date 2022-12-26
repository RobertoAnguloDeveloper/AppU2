package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                TableRow rowHeader1 = new TableRow(context);
                TableRow rowHeader2 = new TableRow(context);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT);

                TableRow rowData1 = new TableRow(context);
                TableRow rowData2 = new TableRow(context);

                if(ej4.getListaCompras().size() > 0){
                    ej4.calcularCompra();

                    Typeface typeface = Typeface.defaultFromStyle(Typeface.BOLD);
                    TextView ivaHeader = new TextView(context);
                    ivaHeader.setText("IVA");
                    ivaHeader.setTypeface(typeface);

                    TextView descuentosHeader = new TextView(context);
                    descuentosHeader.setText("DESCUENTOS");
                    descuentosHeader.setTypeface(typeface);

                    TextView totalComprasHeader = new TextView(context);
                    totalComprasHeader.setText("TOTAL");
                    totalComprasHeader.setTypeface(typeface);

                    TextView compraMasAltaHeader = new TextView(context);
                    compraMasAltaHeader.setText("COMPRA MAS ALTA");
                    compraMasAltaHeader.setTypeface(typeface);

                    rowHeader1.addView(ivaHeader);
                    rowHeader1.addView(descuentosHeader);
                    rowHeader2.addView(totalComprasHeader);
                    rowHeader2.addView(compraMasAltaHeader);

                    tableCompra.addView(rowHeader1, layoutParams);

                    TextView iva = new TextView(context);
                    iva.setText(String.valueOf(ej4.getTotalIva()));

                    TextView descuentos = new TextView(context);
                    descuentos.setText(String.valueOf(ej4.getTotalDescuentos()));

                    TextView totalCompras = new TextView(context);
                    totalCompras.setText(String.valueOf(ej4.getTotalCompras()));

                    TextView compraMasAlta = new TextView(context);
                    compraMasAlta.setText(String.valueOf(ej4.compraMasAlta()));

                    rowData1.addView(iva);
                    rowData1.addView(descuentos);
                    rowData2.addView(totalCompras);
                    rowData2.addView(compraMasAlta);

                    tableCompra.addView(rowData1);

                    tableCompra.addView(rowHeader2);
                    tableCompra.addView(rowData2);
                }else{
                    Toast.makeText(context,"Debe al menos hacer una compra", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}