package com.example.market.Service.Product;

import com.example.market.DTO.ImportDetail.AddImportDetailDTO;
import com.example.market.DTO.Product.AddProductDTO;
import com.example.market.DTO.Product.ManageProductDTO;
import com.example.market.Entity.Product;
import com.example.market.Mapper.Product.ProductMapper;
import com.example.market.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;
    private ProductMapper productMapper;
    @Autowired
    public ProductService(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Transactional
    public List<ManageProductDTO> manageProducts() {
        List<Product> products = productRepo.findAll();
        return productMapper.mapToDTO(products);
    }

    @Transactional
    public void addProduct(long id_product, AddProductDTO addProductDTO) {
        Product product = productRepo.findById(id_product).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(addProductDTO.getName());
//        product.setProduct_Category(addProductDTO.getgetCategoryName());
        product.setDescription(addProductDTO.getDescription());
        product.setPrice(addProductDTO.getPrice());
        product.setUnit(addProductDTO.getUnit());
        product.setDescription(addProductDTO.getDescription());
        product.setManufacturer(addProductDTO.getManufacturer());
        productRepo.save(product);

    }
}
