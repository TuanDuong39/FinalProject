package com.example.market.Mapper.Product;

import com.example.market.DTO.Product.ManageProductDTO;
import com.example.market.Entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ProductMapper {
    private ModelMapper modelMapper;
    @Autowired
    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public ManageProductDTO mapToDTO(Product product) {
        ManageProductDTO manageProductDTO = new ManageProductDTO();
        manageProductDTO.setName(product.getName());
        manageProductDTO.setPrice(product.getPrice());
        manageProductDTO.setDescription(product.getDescription());
        manageProductDTO.setUnit(product.getUnit());
        manageProductDTO.setManufacturer(product.getManufacturer());
        manageProductDTO.setCategoryName(product.getProduct_Category().getName());
        return manageProductDTO;
    }

    public List<ManageProductDTO> mapToDTO(List<Product> products) {
        return products.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //update

}
