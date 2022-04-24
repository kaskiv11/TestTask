package com.example.TestTask.service.imp;

import com.example.TestTask.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    void updateCustomer(Customer customer,long id);
    boolean createCustomer(Customer customer);
    Customer findCustomerByEmail(String email);
    boolean deleteCustomerId(Long customerId);
    Optional<Customer> findCustomerById(Long customerId);
    Customer findCustomerByFullName(String fullName);
    Customer findCustomerByPhone(String phone);
    List<Customer> allCustomers();
}

