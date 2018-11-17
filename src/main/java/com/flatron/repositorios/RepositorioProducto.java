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
package com.flatron.repositorios;

import com.flatron.modelos.Producto;
import com.flatron.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Franco Morbidoni <fgmorbidoni@gmail.com>
 */
public class RepositorioProducto {
    private static SessionFactory factory;
    /**
    *Los tres metodos siguientes realizan las tareas de ABM de los productos.
    */
    public void guardarProducto(Producto producto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(producto);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void eliminarProducto(Producto producto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(producto);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }      
    }
    
    public void actualizarProducto(Producto producto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(producto);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /**
    *Genera un array con todos los productos almacenados.
    */
    public ArrayList<Producto> obtenerTodosLosProductos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Producto> arrayADevolver = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List productoList = session.createQuery("FROM  Producto").list();
            for (Iterator iterator = productoList.iterator(); iterator.hasNext();) {
                Producto producto = (Producto) iterator.next();
                arrayADevolver.add(producto);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return arrayADevolver;
    }
    
    /**
    *Genera un array con todos los productos cuyo nombre se asemege al buscado.
    */
    public ArrayList<Producto> obtenerProductosSegunNombre(String nombreBuscado){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Producto> arrayADevolver = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM  Producto WHERE nombre like concat('%',:nombre,'%')");
            query.setParameter("nombre", nombreBuscado);
            List productoList = query.list();
            for (Iterator iterator = productoList.iterator(); iterator.hasNext();) {
                Producto producto = (Producto) iterator.next();
                arrayADevolver.add(producto);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return arrayADevolver;
    }
    
    /**
    *Obtiene el producto al cual le pertenece el codigo ingresado.
    */
    public Producto obtenerUnicoProductoPorCodigo(int codigo){
        Producto productoADevolver = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            productoADevolver=(Producto)session.get(Producto.class, codigo);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }      
        return productoADevolver;
    }
    
    /*
    *Metodo que luego de identificar un producto, consulta si su stock actual es menor o igual al stock minimo, 
    *devolviendo un booleano como respusta.
    */
    public boolean verificarStock(int codigo){
        Producto productoElegido = null;
        boolean alcanzoStockMinimo = false; //true->se alcanzo el stock minimo, false-> no se alcanzo el stock minimo
        
        productoElegido = obtenerUnicoProductoPorCodigo(codigo);
        
        if (productoElegido.getStock()<=productoElegido.getStockMinimo()){
            alcanzoStockMinimo=true;
        }
        
        return alcanzoStockMinimo;
    }
    
}
