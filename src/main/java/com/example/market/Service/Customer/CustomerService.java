package com.example.market.Service.Customer;

import com.example.market.DTO.Customer.CustomerDTO;
import com.example.market.Entity.Customer;
import com.example.market.Mapper.Customer.CustomerMapper;
import com.example.market.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;
    private CustomerMapper customerMapper;
    @Autowired
    public CustomerService(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    // get all customer
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        return customerMapper.mapToListDTO(customers);
    }

    // get 1 customer
    public CustomerDTO getCustomerById(long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Customer not found"));
        return customerMapper.mapToDTO(customer);
    }

    // add customer
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.mapToCustomer(customerDTO);
        customerRepo.save(customer);
        return customerDTO;
    }

    // update customer
    public CustomerDTO updateCustomer( long id,CustomerDTO customerDTO) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerMapper.updateCustomerFromDTO(customerDTO, customer);

        customerRepo.save(customer);
        return customerDTO;
    }

    //delete customer
    public void deleteCustomer(long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepo.delete(customer);
    }
}
