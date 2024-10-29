/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarioluiszerne;

import java.util.ArrayList;

public class GestorDeInventario {
    private ArrayList<Artículo> artículos;

    public GestorDeInventario() {
        artículos = new ArrayList<>();
    }

    public void agregarArtículo(Artículo artículo) {
        artículos.add(artículo);
    }

    public void eliminarArtículo(String nombre) {
        artículos.removeIf(a -> a.getNombre().equalsIgnoreCase(nombre));
    }

    public String listarArtículos() {
        StringBuilder sb = new StringBuilder();
        for (Artículo a : artículos) {
            sb.append(a).append("\n");
        }
        return sb.toString();
    }
}
