package com.example.market.Mapper.Customer;

import com.example.market.DTO.Customer.CustomerDTO;
import com.example.market.Entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    }

    // Ánh xạ entity -> DTO
    public CustomerDTO mapToDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    // Chuyển List entity -> List DTO
    public List<CustomerDTO> mapToListDTO(List<Customer> customers) {
        return customers.stream() // customers: danh sách (List<Customer>), .stream: chuyển đổi thành luồng và duyệt qua các phần tử
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Ánh xạ DTO -> Entity
    public Customer mapToCustomer(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }

    public void updateCustomerFromDTO(CustomerDTO customerDTO, Customer customer) {
        modelMapper.map(customerDTO, customer);
    }


}
