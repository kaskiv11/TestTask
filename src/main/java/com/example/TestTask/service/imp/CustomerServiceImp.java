package com.example.TestTask.service.imp;

import com.example.TestTask.model.Customer;
import com.example.TestTask.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public static boolean validEmail(String email){
        String regex = "^\\+(?:[0-9] ?){2,16}[0-9]$";

        Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void updateCustomer(Customer customer, long id) {
        Customer customer1= (Customer) customerRepository.findAllById(Collections.singleton((id)));
        customer1.setEmail(customer.getEmail());
        customer1.setFullName(customer.getFullName());
        customer1.setPhone(customer.getPhone());
        customer1.setIsActive(customer.getIsActive());
        customerRepository.save(customer1);
    }
    @Override
    public boolean createCustomer(Customer customer) {

        Customer customerFromDB = customerRepository.findByEmail(customer.getEmail());
        if (customerFromDB != null) {
            return false;
        }
        if(!validEmail(customer.getEmail())){
            return false;
        }
        customer.setIsActive(true);
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public boolean deleteCustomerId(Long customerId) {
        if (customerRepository.findById(customerId).isPresent()) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Customer> findCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer findCustomerByFullName(String fullName) {
        return customerRepository.findByFullName(fullName);
    }

    @Override
    public Customer findCustomerByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public List<Customer> allCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
}
