package com.wissen.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.e_commerce.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
 public Customer findFirstByEmail(String email);
}
