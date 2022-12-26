package com.udc.aau2.ejercicios;

import android.widget.EditText;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Validador {
    public static void limpiarCampos(EditText campo){
        campo.setText("");
    }

    public static void limpiarCampos(List<EditText> campos){
        for (EditText campo : campos) {
            campo.setText("");
        }
    }

    public static String separadorDeMiles(Double num){
        String numStr = NumberFormat.getNumberInstance(Locale.US).format(num);
        return numStr;
    }
}
