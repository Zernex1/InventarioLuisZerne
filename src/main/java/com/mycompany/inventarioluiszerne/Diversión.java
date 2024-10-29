/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarioluiszerne;

 
public class Diversión extends Artículo {
    private String categoría;

    public Diversión(String nombre, double precio, int cantidad, String categoría) {
        super(nombre, precio, cantidad);
        this.categoría = categoría;
    }

    @Override
    public String toString() {
        return super.toString() + " - Categoría: " + categoría;
    }
}
