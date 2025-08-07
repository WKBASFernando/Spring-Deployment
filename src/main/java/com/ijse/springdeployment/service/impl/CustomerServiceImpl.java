package com.ijse.springdeployment.service.impl;

import com.ijse.springdeployment.entity.Customer;
import com.ijse.springdeployment.repo.CustomerRepo;
import com.ijse.springdeployment.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomersById(Long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer existCustomer = customerRepo.findById(customer.getId()).get();
        existCustomer.setFirstName(customer.getFirstName());
        existCustomer.setLastName(customer.getLastName());
        return customerRepo.save(existCustomer);
    }

    @Override
    public void deleteCustomer(Customer customer) {

    }
}
