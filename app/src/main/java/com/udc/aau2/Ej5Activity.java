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

import com.udc.aau2.ejercicios.Validador;

import java.util.ArrayList;
import java.util.List;

public class Ej5Activity extends AppCompatActivity {
    private EditText programa;
    private Button btnAgregarPrograma;
    private RadioButton rbActualizar, rbEliminar;
    private ListView listaProgramas;
    private List<String> programas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej5);

        programa = findViewById(R.id.programa);
        btnAgregarPrograma = findViewById(R.id.btnAgregarPrograma);
        rbActualizar = findViewById(R.id.rbActualizar);
        rbEliminar = findViewById(R.id.rbEliminar);
        listaProgramas = findViewById(R.id.listaProgramas);
        programas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, programas);
        listaProgramas.setAdapter(adapter);

        listaProgramas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapter.getItem(i);

                if(rbActualizar.isChecked()){
                    programa.setText(item);
                }else if(rbEliminar.isChecked()){
                    programas.remove(programas.indexOf(item));
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnAgregarPrograma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevoPrograma = String.valueOf(programa.getText());

                if(!rbActualizar.isChecked()){
                    programas.add(nuevoPrograma);
                    adapter.notifyDataSetChanged();
                    Validador.limpiarCampos(programa);
                }

            }
        });
    }
}