package com.udc.aau2.ejercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej4 {
    private List<Compra> listaCompras;
    private BigDecimal bigDecimal;
    private Double totalCompras, iva, totalIva, minDescuento, porcentajeDescuento, totalDescuentos;

    public Ej4() {
        this.listaCompras = new ArrayList<>();
        this.iva = new Compra().getIva();
        this.minDescuento = new Compra().getMinDescuento();
        this.porcentajeDescuento = new Compra().getPorcentaDescuento();
        this.totalCompras = 0.0;
        this.totalIva = 0.0;
        this.totalDescuentos = 0.0;
    }

    public Double redondearDecimales(Double numero, Integer decimales){
        bigDecimal = BigDecimal.valueOf(numero);
        BigDecimal rounded = bigDecimal.setScale(decimales, RoundingMode.HALF_UP);
        numero = rounded.doubleValue();
        return numero;
    }

    public void agregarALista(Compra compra){
        this.listaCompras.add(compra);
    }

    public Double calcularCompra(){

        for (int i = 0; i < this.listaCompras.size(); i++) {
            this.totalCompras += this.listaCompras.get(i).getCompra();
        }

        this.totalIva = this.totalCompras * this.iva;
        this.totalIva = redondearDecimales(this.totalIva, 2);

        if(this.totalCompras > this.minDescuento){
            this.totalDescuentos = this.totalCompras * this.porcentajeDescuento;
            this.totalDescuentos = redondearDecimales(this.totalDescuentos, 2);
        }

        this.totalCompras = this.totalCompras + this.totalIva - this.totalDescuentos;

        this.totalCompras = redondearDecimales(this.totalCompras, 2);

        return totalCompras;
    }

    public Double compraMasAlta(){
        Double compraMasAlta = 0.0;

        if(listaCompras.size() > 0){
            Double [] array = new Double[listaCompras.size()];

            for (int i = 0; i < array.length; i++) {
                array[i] = listaCompras.get(i).getCompra();
            }

            Arrays.sort(array);

            compraMasAlta = array[array.length-1];
        }

        return compraMasAlta;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public Double getTotalCompras() {
        return totalCompras;
    }

    public Double getIva() {
        return iva;
    }

    public Double getTotalIva() {
        return totalIva;
    }

    public Double getMinDescuento() {
        return minDescuento;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public Double getTotalDescuentos() {
        return totalDescuentos;
    }
}
