package com.udc.aau2.ejercicios;

public class Compra {
    private Double compra;
    private Double compraConDescuento;
    private static final Double iva = 0.19;
    private static final Double descuento = 0.1;
    private static final Double minDescuento = 100000.0;

    public Compra() {
        this.compraConDescuento = 0.0;
        this.compra = 0.0;
    }

    public Double getCompra() {
        return compra;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public Double getCompraConDescuento() {
        return compraConDescuento;
    }

    public void setCompraConDescuento(Double compraConDescuento) {
        this.compraConDescuento = compraConDescuento;
    }

    public Double getIva() {
        return iva;
    }

    public Double getDescuento() {
        return descuento;
    }

    public Double getMinDescuento() {
        return minDescuento;
    }

}
