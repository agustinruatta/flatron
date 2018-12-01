/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flatron.repositorios.unidaddemedida;

import com.flatron.modelos.UnidadDeMedida;
import com.flatron.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author laboratorio
 */
public class RepositorioUnidadDeMedida {

    public void guardar(UnidadDeMedida unidadDeMedida) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(unidadDeMedida);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public ArrayList<UnidadDeMedida> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from unidadmedida");
        return (ArrayList<UnidadDeMedida>) query.list();

    }

    public void remove(UnidadDeMedida unidadDeMedida) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(unidadDeMedida);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
