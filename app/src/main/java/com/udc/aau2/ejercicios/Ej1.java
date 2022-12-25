package com.udc.aau2.ejercicios;

public class Ej1 {
    public Integer calcularCubo(Integer n){
        Integer result = Integer.valueOf((int) Math.pow(n, 3));
        return result;
    }

    public String eresAfortunado(Integer n){
        if(n > 100){
            return "Eres muy afortunado";
        }

        return "";
    }
}
