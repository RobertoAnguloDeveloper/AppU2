package com.udc.aau2.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ej4 {
    private List<Compra> listaCompras;
    private Double totalCompras, iva, descuentoPorMayor;

    public Ej4() {
        this.listaCompras = new ArrayList<>();
        this.iva = new Compra().getIva();
        this.descuentoPorMayor = new Compra().getDescuento();
        this.totalCompras = 0.0;
    }

    public void agregarALista(Compra compra){
        this.listaCompras.add(compra);
    }

    public double calcularCompra(){

        for (int i = 0; i < this.listaCompras.size(); i++) {
            if(this.listaCompras.get(i).getCompra() > this.listaCompras.get(i).getMinDescuento()){
                Double compraConIva = this.listaCompras.get(i).getCompra() * iva;
                Double compraConDescuento = this.listaCompras.get(i).getCompra() * descuentoPorMayor;
                Double descuentos = compraConDescuento + compraConIva;
                Double conDescuentos = this.listaCompras.get(i).getCompra() - descuentos;
                this.listaCompras.get(i).setCompraConDescuento(conDescuentos);
            }else{
                Double compraConIva = this.listaCompras.get(i).getCompra() * iva;
                Double conDescuentos = this.listaCompras.get(i).getCompra() - compraConIva;
                this.listaCompras.get(i).setCompraConDescuento(conDescuentos);
            }

            totalCompras += this.listaCompras.get(i).getCompraConDescuento();
        }

        return totalCompras;
    }
}
