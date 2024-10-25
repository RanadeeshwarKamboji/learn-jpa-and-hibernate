package com.rana.groceries.learn_jpa_and_hibernate.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaRepository extends JpaRepository<Product, Long> {
}
