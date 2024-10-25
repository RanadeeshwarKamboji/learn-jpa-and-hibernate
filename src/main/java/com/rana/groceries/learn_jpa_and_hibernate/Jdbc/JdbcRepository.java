package com.rana.groceries.learn_jpa_and_hibernate.Jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcRepository {
    @Autowired
    private JdbcTemplate template;

    private String DEFAULT_QUERY =
            """
                    Insert into products(id, name, price, quantity)
                    values (1, 'Rice', 70, 700)
            """;
    public void add_to_database(){
        template.update(DEFAULT_QUERY);
    }
    private String INSERT_QUERY =
            """
                    Insert into products(id, name, price, quantity)
                    values (?,?,?,?)
            """;
    private String DELETE_QUERY =
            """
                    delete from products
                    where id = ?
            """;

    private String GET_QUERY =
            """
                select * from products
            """;

    public void save(Product p){
        template.update(INSERT_QUERY, p.getId(),p.getName(), p.getPrice(), p.getQuantity());
    }

    public void deleteById(long id){
        template.update(DELETE_QUERY, id);
    }

    public List<Product> findAll(){
        return template.query(GET_QUERY, new BeanPropertyRowMapper<>(Product.class));
    }
}
