package com.rana.groceries.learn_jpa_and_hibernate;

//import com.rana.groceries.learn_jpa_and_hibernate.Jdbc.Product;
//import com.rana.groceries.learn_jpa_and_hibernate.Jdbc.JdbcRepository;
//import com.rana.groceries.learn_jpa_and_hibernate.Jpa.JpaEntityManagerRepository;
import com.rana.groceries.learn_jpa_and_hibernate.Jpa.Product;
import com.rana.groceries.learn_jpa_and_hibernate.Jpa.SpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

//    @Autowired
//    JdbcRepository repository;

//    @Autowired
//    JpaEntityManagerRepository repository;

    @Autowired
    SpringDataJpaRepository repository;

    @RequestMapping("/products")
    public List<Product> getProducts(){
        return repository.findAll();
    }

    @RequestMapping("/products/insert")
    public String  insertProduct(@RequestBody Product product){
        repository.save(product);
        return "Inserted Successfully";
    }

    @RequestMapping("/products/delete")
    public String deleteProduct(@RequestParam(required = true) long id){
        repository.deleteById(id);
        return "Deleted Successfully";
    }

}
