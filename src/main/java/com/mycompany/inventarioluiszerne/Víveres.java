/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarioluiszerne;

public class Víveres extends Artículo {
    private String marca;

    public Víveres(String nombre, double precio, int cantidad, String marca) {
        super(nombre, precio, cantidad);
        this.marca = marca;
    }

    @Override
    public String toString() {
        return super.toString() + " - Marca: " + marca;
    }
}
