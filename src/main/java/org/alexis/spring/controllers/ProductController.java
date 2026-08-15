package org.alexis.spring.controllers;

import org.alexis.spring.domain.Product;
import org.alexis.spring.services.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos") // todos los endpoints piden esto adelante por si tenemos distintos controladores
public class ProductController {

    ProductServiceImpl productService = new ProductServiceImpl();

    @RequestMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

}
