package com.example.market.Controller.Product;

import com.example.market.DTO.Product.AddProductDTO;
import com.example.market.DTO.Product.ManageProductDTO;
import com.example.market.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addProduct")
    public void addProduct(@RequestParam long id_product,@RequestBody AddProductDTO addProductDTO) {
        productService.addProduct(id_product,addProductDTO);
    }

}
