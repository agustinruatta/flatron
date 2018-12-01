/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.repositorios;

import com.flatron.modelos.Compra;
import com.flatron.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author santiago
 */
public class RepositorioCompra {
    private static SessionFactory factory;
    private static ArrayList<Compra> listadoCompras;
    
    public RepositorioCompra() {
        this.listadoCompras = new ArrayList<Compra>();
    }
    
    public void GuardarCompra(Compra compra){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.save(compra);
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
    
    public ArrayList<Compra> getListadoCompras() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList<Compra> arrayCompras = new ArrayList<>();
        
        try {
            tx = session.beginTransaction();
            List compraLista = session.createQuery("FROM Compras").list();
            for (Iterator iterator = compraLista.iterator(); iterator.hasNext();) {
                Compra compra = (Compra) iterator.next();
                arrayCompras.add(compra);
            }
            tx.begin();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }   finally {
            session.close();
            }
        return arrayCompras;
    }
}
