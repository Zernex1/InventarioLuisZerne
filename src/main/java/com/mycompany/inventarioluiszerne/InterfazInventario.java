/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.inventarioluiszerne;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class InterfazInventario extends JFrame {
    private GestorDeInventario gestor;
    private JTextArea areaTexto;

    public InterfazInventario() {
        gestor = new GestorDeInventario();
        setTitle("Inventario - Estilo Naranja y Negro");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear las pestañas
        JTabbedPane pestañas = new JTabbedPane();
        pestañas.addTab("Víveres", crearPanelVíveres());
        pestañas.addTab("Diversión", crearPanelDiversión());

        // Área de texto para mostrar los artículos
        areaTexto = new JTextArea(15, 50);
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Arial", Font.BOLD, 14));
        areaTexto.setForeground(Color.BLACK);
        areaTexto.setBackground(new Color(255, 179, 71));  // Naranja claro
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Artículos en Inventario"));

        // Botón Exportar
        JButton botonExportar = new JButton("Exportar");
        botonExportar.setFont(new Font("Arial", Font.BOLD, 14));
        botonExportar.setBackground(new Color(255, 140, 0));  // Naranja oscuro
        botonExportar.setForeground(Color.BLACK);
        botonExportar.addActionListener(e -> exportarArtículos());

        // Layout principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(pestañas, BorderLayout.CENTER);
        panelPrincipal.add(scrollPane, BorderLayout.SOUTH);
        panelPrincipal.add(botonExportar, BorderLayout.NORTH);

        add(panelPrincipal);
        setVisible(true);
    }

    private JPanel crearPanelVíveres() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));  // Añadí más espacio entre componentes
        panel.setBackground(new Color(255, 140, 0));  // Fondo naranja oscuro

        // Campos de texto con alineación izquierda y fuente Arial 14 en negrita
        JTextField campoNombre = crearCampoTexto();
        JTextField campoPrecio = crearCampoTexto();
        JTextField campoCantidad = crearCampoTexto();
        JTextField campoMarca = crearCampoTexto();

        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);
        panel.add(new JLabel("Precio:"));
        panel.add(campoPrecio);
        panel.add(new JLabel("Cantidad:"));
        panel.add(campoCantidad);
        panel.add(new JLabel("Marca:"));
        panel.add(campoMarca);

        JButton botonAgregar = new JButton("Agregar Víveres");
        botonAgregar.setFont(new Font("Arial", Font.BOLD, 14));
        botonAgregar.setBackground(Color.BLACK);
        botonAgregar.setForeground(Color.WHITE);
        botonAgregar.addActionListener(e -> {
            String nombre = campoNombre.getText();
            double precio = Double.parseDouble(campoPrecio.getText());
            int cantidad = Integer.parseInt(campoCantidad.getText());
            String marca = campoMarca.getText();

            gestor.agregarArtículo(new Víveres(nombre, precio, cantidad, marca));
            actualizarAreaTexto();
        });

        panel.add(botonAgregar);
        return panel;
    }

    private JPanel crearPanelDiversión() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(new Color(255, 140, 0));  // Fondo naranja oscuro

        JTextField campoNombre = crearCampoTexto();
        JTextField campoPrecio = crearCampoTexto();
        JTextField campoCantidad = crearCampoTexto();
        JTextField campoCategoria = crearCampoTexto();

        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);
        panel.add(new JLabel("Precio:"));
        panel.add(campoPrecio);
        panel.add(new JLabel("Cantidad:"));
        panel.add(campoCantidad);
        panel.add(new JLabel("Categoría:"));
        panel.add(campoCategoria);

        JButton botonAgregar = new JButton("Agregar Diversión");
        botonAgregar.setFont(new Font("Arial", Font.BOLD, 14));
        botonAgregar.setBackground(Color.BLACK);
        botonAgregar.setForeground(Color.WHITE);
        botonAgregar.addActionListener(e -> {
            String nombre = campoNombre.getText();
            double precio = Double.parseDouble(campoPrecio.getText());
            int cantidad = Integer.parseInt(campoCantidad.getText());
            String categoria = campoCategoria.getText();

            gestor.agregarArtículo(new Diversión(nombre, precio, cantidad, categoria));
            actualizarAreaTexto();
        });

        panel.add(botonAgregar);
        return panel;
    }

    private JTextField crearCampoTexto() {
        JTextField campo = new JTextField();
        campo.setFont(new Font("Arial", Font.BOLD, 14));
        campo.setHorizontalAlignment(JTextField.LEFT);
        return campo;
    }

    private void actualizarAreaTexto() {
        areaTexto.setText(gestor.listarArtículos());
    }

    private void exportarArtículos() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                writer.write(areaTexto.getText());
                JOptionPane.showMessageDialog(this, "Artículos exportados correctamente.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al exportar artículos.");
            }
        }
    }

    public static void main(String[] args) {
        new InterfazInventario();
    }
}

