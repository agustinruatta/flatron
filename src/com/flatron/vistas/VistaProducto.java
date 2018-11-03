/*
 * Copyright (C) 2018 Franco Morbidoni <fgmorbidoni@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.flatron.vistas;

import com.flatron.modelos.Producto;
import com.flatron.presentadores.ModeloTablaProducto;
import com.flatron.presentadores.PresentadorProducto;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public final class VistaProducto extends javax.swing.JFrame {

    private final PresentadorProducto presentador;

    /**
     * Creates new form VistaProducto
     */
    public VistaProducto() {
        initComponents();

        this.presentador = new PresentadorProducto(this);
        this.setUnidadesMedidaProductoComboBox();
        
        //Crea una tabla limpia.
        this.presentador.crearTablaInicial();

        //Actualiza los campos de la pantalla al seleccionar un producto de la tabla.
        this.productosTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = productosTable.rowAtPoint(evt.getPoint());                
                if (fila >= 0 ) {                    
                    ModeloTablaProducto tabla= (ModeloTablaProducto) productosTable.getModel();
                    Producto productoSeleccionado = tabla.ObtenerProducto(fila);
                    presentador.cargarDatosProducto(productoSeleccionado);                   
                }
            }
        });

    }

    public JTable getProductosTable() {
        return productosTable;
    }

    public void setUnidadesMedidaProductoComboBox() {
        //Solo como metodo de prueba, necesita ser modificado para recivir las unidades de medida registradas.
        String[] lista = {"Prueba","Prueba2"};
        this.unidadesMedidaProductoComboBox.setModel(new javax.swing.DefaultComboBoxModel(lista));
    }

    public JTextField getCostoProductoTextField() {
        return costoProductoTextField;
    }

    public JTextField getGananciaProductoTextField() {
        return gananciaProductoTextField;
    }

    public JTextField getBuscarProductoTextField() {
        return buscarProductoTextField;
    }

    public JTextField getMarcaProductoTextField() {
        return marcaProductoTextField;
    }

    public JTextField getNombreProductoTextField() {
        return nombreProductoTextField;
    }

    public JTextField getRubroProductoTextField() {
        return rubroProductoTextField;
    }

    public JTextField getStockActualProductoTextField() {
        return stockActualProductoTextField;
    }

    public JTextField getStockMinimoProductoTextField() {
        return stockMinimoProductoTextField;
    }

    public JComboBox<String> getUnidadesMedidaProductoComboBox() {
        return unidadesMedidaProductoComboBox;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nombreProductoTextField = new javax.swing.JTextField();
        marcaProductoTextField = new javax.swing.JTextField();
        costoProductoTextField = new javax.swing.JTextField();
        gananciaProductoTextField = new javax.swing.JTextField();
        stockActualProductoTextField = new javax.swing.JTextField();
        stockMinimoProductoTextField = new javax.swing.JTextField();
        rubroProductoTextField = new javax.swing.JTextField();
        Separador = new javax.swing.JSeparator();
        buscarProductoTextField = new javax.swing.JTextField();
        buscarProductoButton = new javax.swing.JButton();
        guardarProductoButton = new javax.swing.JButton();
        PanelScrollTabla = new javax.swing.JScrollPane();
        productosTable = new javax.swing.JTable();
        modificarProductoButton = new javax.swing.JButton();
        eliminarProductoButton = new javax.swing.JButton();
        unidadesMedidaProductoComboBox = new javax.swing.JComboBox<>();
        mostrarTodoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Producto");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Costo:");

        jLabel5.setText("Ganancia:");

        jLabel6.setText("Marca:");

        jLabel2.setText("Unidad de Medida:");

        jLabel7.setText("Stock Actual:");

        jLabel8.setText("Stock Minimo:");

        jLabel9.setText("Rubro:");

        buscarProductoButton.setText("Buscar");
        buscarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProductoButtonActionPerformed(evt);
            }
        });

        guardarProductoButton.setText("Guardar");
        guardarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarProductoButtonActionPerformed(evt);
            }
        });

        productosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        PanelScrollTabla.setViewportView(productosTable);

        modificarProductoButton.setText("Modificar");
        modificarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProductoButtonActionPerformed(evt);
            }
        });

        eliminarProductoButton.setText("Eliminar");
        eliminarProductoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoButtonActionPerformed(evt);
            }
        });

        mostrarTodoButton.setText("Mostrar Todo");
        mostrarTodoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTodoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Separador)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(guardarProductoButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelScrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(marcaProductoTextField)
                                    .addComponent(nombreProductoTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(costoProductoTextField)
                                    .addComponent(gananciaProductoTextField)
                                    .addComponent(stockActualProductoTextField)
                                    .addComponent(stockMinimoProductoTextField)
                                    .addComponent(rubroProductoTextField)
                                    .addComponent(unidadesMedidaProductoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscarProductoTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarProductoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificarProductoButton)
                        .addGap(18, 18, 18)
                        .addComponent(mostrarTodoButton)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarProductoButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreProductoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(marcaProductoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(unidadesMedidaProductoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(costoProductoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(gananciaProductoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(stockActualProductoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(stockMinimoProductoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rubroProductoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarProductoButton)
                .addGap(13, 13, 13)
                .addComponent(Separador, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarProductoButton)
                    .addComponent(buscarProductoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(PanelScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modificarProductoButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminarProductoButton)
                        .addComponent(mostrarTodoButton)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarProductoButtonActionPerformed
        this.presentador.botonGuardarProducto();
    }//GEN-LAST:event_guardarProductoButtonActionPerformed

    private void buscarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProductoButtonActionPerformed
        this.presentador.botonBuscarProducto();
    }//GEN-LAST:event_buscarProductoButtonActionPerformed

    private void mostrarTodoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTodoButtonActionPerformed
        this.presentador.botonMostrarTodosLosProductos();
    }//GEN-LAST:event_mostrarTodoButtonActionPerformed

    private void modificarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProductoButtonActionPerformed
        this.presentador.botonModificarProducto();
    }//GEN-LAST:event_modificarProductoButtonActionPerformed

    private void eliminarProductoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProductoButtonActionPerformed
       this.presentador.botonEliminarProducto();
    }//GEN-LAST:event_eliminarProductoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PanelScrollTabla;
    private javax.swing.JSeparator Separador;
    private javax.swing.JButton buscarProductoButton;
    private javax.swing.JTextField buscarProductoTextField;
    private javax.swing.JTextField costoProductoTextField;
    private javax.swing.JButton eliminarProductoButton;
    private javax.swing.JTextField gananciaProductoTextField;
    private javax.swing.JButton guardarProductoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField marcaProductoTextField;
    private javax.swing.JButton modificarProductoButton;
    private javax.swing.JButton mostrarTodoButton;
    private javax.swing.JTextField nombreProductoTextField;
    private javax.swing.JTable productosTable;
    private javax.swing.JTextField rubroProductoTextField;
    private javax.swing.JTextField stockActualProductoTextField;
    private javax.swing.JTextField stockMinimoProductoTextField;
    private javax.swing.JComboBox<String> unidadesMedidaProductoComboBox;
    // End of variables declaration//GEN-END:variables
}