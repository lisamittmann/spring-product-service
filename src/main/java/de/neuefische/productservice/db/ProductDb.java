package de.neuefische.productservice.db;

import de.neuefische.productservice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductDb {

    private ArrayList<Product> productList = new ArrayList<Product>(List.of(
            new Product("no1", "Tisch"),
            new Product("no2", "Stuhl"),
            new Product ("no3", "Decke"),
            new Product("no4", "Sofa"),
            new Product("no5", "Teppich")
    ));

    public ArrayList<Product> listProducts(){
        return this.productList;
    }

    public Product addProduct(Product product) {
        this.productList.add(product);
        return product;
    }

    public boolean productExists(String id) {
        for (Product product : productList) {
            if(product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}
