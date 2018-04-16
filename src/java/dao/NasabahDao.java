/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Nasabah;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.NewHibernateUtil;

/**
 *
 * @author ASUS A455L
 */
public class NasabahDao implements InterfaceDao {

    public SessionFactory factory;
    public Session session;
    public Transaction transaction;
    public FunctionDao fdao;
    
    public NasabahDao(){
        this.fdao = new FunctionDao(NewHibernateUtil.getSessionFactory());
    }

    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean delete(Object object) {
        return fdao.delete(Nasabah.class,object.toString());
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Nasabah");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Nasabah WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Nasabah where ktp='" + id + "'");
    }
}
