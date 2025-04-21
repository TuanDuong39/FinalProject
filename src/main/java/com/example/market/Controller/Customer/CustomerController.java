package com.example.market.Controller.Customer;

import com.example.market.DTO.Customer.CustomerDTO;
import com.example.market.Service.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customerDetail/{id}")
    public CustomerDTO getCustomer(@PathVariable long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/addCustomer")
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping("/updateCustomer/{id}")
    public CustomerDTO updateCustomer(@PathVariable long id ,@RequestBody CustomerDTO customerDTO) {
        System.out.print("id:"+id);
        System.out.print("update success" + customerDTO);
        return customerService.updateCustomer(id,customerDTO);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
    }

}
