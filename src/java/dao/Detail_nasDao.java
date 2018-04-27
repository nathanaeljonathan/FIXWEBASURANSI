/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DetailNasabah;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.NewHibernateUtil;

/**
 *
 * @author ASUS A455L
 */
public class Detail_nasDao implements InterfaceDao {

    public Session session;
    public SessionFactory factory;
    public Transaction transaction;
    public FunctionDao fdao;

    public Detail_nasDao() {
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
        return fdao.delete(DetailNasabah.class, object.toString());
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM DetailNasabah ORDER BY idDetail");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM DetailNasabah WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from DetailNasabah where idDetail='" + id + "'");
    }
    
     public String getAutoID(){
        return (String) fdao.getById("SELECT CONCAT('DA',LPAD((TO_NUMBER(SUBSTR(MAX(idDetail),3,3))+1),3, '0')) FROM DetailNasabah");
                
    }

}
