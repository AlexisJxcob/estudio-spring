package org.alexis.spring.services;

import org.alexis.spring.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService {

List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1, "Laptop", 1200.0, 10),
        new Product(2, "Smartphone", 800.0, 20),
        new Product(3, "Tablet", 400.0, 15),
        new Product(4, "Monitor", 300.0, 5)));

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
