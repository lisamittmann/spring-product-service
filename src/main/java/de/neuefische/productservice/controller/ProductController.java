package de.neuefische.productservice.controller;

import de.neuefische.productservice.db.ProductDb;
import de.neuefische.productservice.model.Product;
import de.neuefische.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    public final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("list")
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @PutMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> searchProducts(@RequestParam String q){
        return productService.searchProductName(q);
    }
}
