/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.vistas.unidaddemedida;

import com.flatron.modelos.UnidadDeMedida;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author laboratorio
 */
public class TablaUnidadDeMedidaTableModel extends AbstractTableModel {

    private static final int CANTIDAD_COLUMNAS = 2;

    private static final int COLUMNA_NOMBRE = 0;
    private static final int COLUMNA_SIMBOLO = 1;

    private ArrayList<UnidadDeMedida> unidadesDeMedida;

    public TablaUnidadDeMedidaTableModel(ArrayList<UnidadDeMedida> unidadDeMedida) {
        this.unidadesDeMedida = unidadDeMedida;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COLUMNA_NOMBRE:
                return "Nombre";

            case COLUMNA_SIMBOLO:
                return "Simbolo";

            default:
                throw new IllegalArgumentException("Nombre inválido");
        }
    }

    @Override
    public int getRowCount() {
        return this.unidadesDeMedida.size();
    }

    @Override
    public int getColumnCount() {
        return CANTIDAD_COLUMNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UnidadDeMedida unidadDeMedida = this.unidadesDeMedida.get(rowIndex);

        switch (columnIndex) {
            case COLUMNA_NOMBRE:
                return unidadDeMedida.getNombre();

            case COLUMNA_SIMBOLO:
                return unidadDeMedida.getSimbolo();

            default:
                throw new IllegalArgumentException("Columna inválida " + columnIndex);

        }

    }

    public UnidadDeMedida getUnidadDeMedidaSeleccionada(int filaSelecccionada) {
        return this.unidadesDeMedida.get(filaSelecccionada);
    }

}
