package com.example.TestTask.repository;

import com.example.TestTask.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findById(Long id);
    Customer findByEmail(String email);
    Customer findByFullName(String fullName);
    Customer findByPhone(String phone);
}
