package com.example.market.Controller.Product;

import com.example.market.DTO.Product.ManageProductDTO;
import com.example.market.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/manageProduct")
    public List<ManageProductDTO> getProducts() {
        return productService.manageProducts();
    }


}
