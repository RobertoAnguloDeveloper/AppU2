package com.udc.aau2.ejercicios;

public class Compra {
    private Double compra;
    private static final Double iva = 0.19;
    private static final Double porcentaDescuento = 0.1;
    private static final Double minDescuento = 100000.0;

    public Compra() {
        this.compra = 0.0;
    }

    public Double getCompra() {
        return compra;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public Double getIva() {
        return iva;
    }

    public Double getPorcentaDescuento() {
        return porcentaDescuento;
    }

    public Double getMinDescuento() {
        return minDescuento;
    }

}
