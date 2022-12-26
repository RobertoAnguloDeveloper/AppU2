package com.udc.aau2.ejercicios;

import android.widget.EditText;

import java.util.List;

public class Validador {
    public static void limpiarCampos(EditText campo){
        campo.setText("");
    }

    public static void limpiarCampos(List<EditText> campos){
        for (EditText campo : campos) {
            campo.setText("");
        }
    }
}
