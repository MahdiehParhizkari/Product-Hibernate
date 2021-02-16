package com.helman;

import org.hibernate.Session;
import java.util.List;

public class ProductDao {
    public ProductDao(){}

    Session session = Mysession.getsession();

    public List<Product> findAll(){
        return session.createQuery("select p from Product p").getResultList();
    }

    public Product findById(int id){
        return session.find(Product.class, id);
    }

    public void insert(Product product){
        session.getTransaction().begin();
        session.persist(product);
        session.getTransaction().commit();
    }

    public void update(Product product){
        session.getTransaction().begin();
        session.update(product);
        session.getTransaction().commit();
    }

    public void delete(Product product){
        session.getTransaction().begin();
        session.delete(product);
        session.getTransaction().commit();
    }
}