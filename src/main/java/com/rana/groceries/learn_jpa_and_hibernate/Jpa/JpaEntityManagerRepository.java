package com.rana.groceries.learn_jpa_and_hibernate.Jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class JpaEntityManagerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> findAll(){
        //Example for jpql (Java Persistence query language) query
        String jpql = "SELECT p FROM PRODUCTS p";
        List<Product> products = entityManager.createQuery(jpql, Product.class).getResultList();
        return products;
    }

    public void save(Product p){
        entityManager.merge(p);
    }

    public void deleteById(long id){
        Product p = entityManager.find(Product.class,id);
        entityManager.remove(p);
    }
}
