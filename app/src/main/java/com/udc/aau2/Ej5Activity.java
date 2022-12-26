package com.udc.aau2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.udc.aau2.ejercicios.Validador;

import java.util.ArrayList;
import java.util.List;

public class Ej5Activity extends AppCompatActivity {
    private EditText programa;
    private TextView contador;
    private Button btnGuardarPrograma;
    private RadioButton rbAgregar, rbActualizar, rbEliminar;
    private ListView listaProgramas;
    private List<String> programas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej5);

        programa = findViewById(R.id.programa);
        contador = findViewById(R.id.contadorProgramas);
        btnGuardarPrograma = findViewById(R.id.btnGuardarPrograma);
        rbAgregar = findViewById(R.id.rbAgregar);
        rbActualizar = findViewById(R.id.rbActualizar);
        rbEliminar = findViewById(R.id.rbEliminar);
        listaProgramas = findViewById(R.id.listaProgramas);
        programas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.textview_custom, programas);

        listaProgramas.setAdapter(adapter);

        contador.setText(String.valueOf(programas.size()));

        rbAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                programa.setEnabled(true);
                btnGuardarPrograma.setEnabled(true);
                btnGuardarPrograma.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nuevoPrograma = String.valueOf(programa.getText());
                        programas.add(programas.size(), nuevoPrograma);
                        adapter.notifyDataSetChanged();
                        Validador.limpiarCampos(programa);
                        contador.setText(String.valueOf(programas.size()));
                    }
                });
            }
        });

        rbActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                programa.setEnabled(false);
                btnGuardarPrograma.setEnabled(false);
                listaProgramas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String item = adapter.getItem(i);
                        programa.setText(item);
                        programa.setEnabled(true);
                        btnGuardarPrograma.setEnabled(true);
                        btnGuardarPrograma.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String editado = String.valueOf(programa.getText());
                                int index = programas.indexOf(item);
                                programas.set(index, editado);
                                adapter.notifyDataSetChanged();
                                Validador.limpiarCampos(programa);
                                contador.setText(String.valueOf(programas.size()));
                                programa.setEnabled(false);
                                btnGuardarPrograma.setEnabled(false);
                            }
                        });
                    }
                });
            }
        });

        rbEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                programa.setEnabled(false);
                btnGuardarPrograma.setEnabled(false);
                listaProgramas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String item = adapter.getItem(i);
                        programas.remove(programas.indexOf(item));
                        adapter.notifyDataSetChanged();
                        contador.setText(String.valueOf(programas.size()));
                    }
                });
            }
        });
    }
}