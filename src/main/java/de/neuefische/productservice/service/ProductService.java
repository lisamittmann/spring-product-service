package de.neuefische.productservice.service;

import de.neuefische.productservice.db.ProductDb;
import de.neuefische.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductDb productDb;

    @Autowired
    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }

    public List<Product> listProducts() {
        return productDb.listProducts();
    }

    public Product addProduct(Product product) {
        return productDb.addProduct(product);
    }

    public List<Product> searchProductName(String q) {
        return productDb.listProducts().stream()
                .filter(s -> s.getName().toLowerCase(Locale.ROOT).contains(q.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }
}
