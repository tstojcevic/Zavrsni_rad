/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.controller;

import hotel.model.Entitet;
import hotel.util.HibernateUtil;
import hotel.util.HotelException;
import java.util.List;
import org.hibernate.Session;


/**
 *
 * @author Korisnik
 */
public abstract class Obrada<T extends Entitet>{
    
    protected T entitet;
    protected Session session;
    
    public abstract List<T> read();
    
    protected abstract void kontrolaUnos() throws HotelException;
    
    protected abstract void kontrolaPromjena() throws HotelException;
    
    protected abstract void kontrolaBrisanje() throws HotelException;
    
    public Obrada(){
        this.session = HibernateUtil.getSession();
    }
    
    public void create() throws HotelException{
        if(entitet==null){
            throw new HotelException("Entitet je null");
        }
        kontrolaUnos();
        persist();
    
    }
    
    public void update() throws HotelException{
        kontrolaPromjena();
        persist();
    }
    
    public void delete() throws HotelException{
        kontrolaBrisanje();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }

    private void persist() {
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
    
}
