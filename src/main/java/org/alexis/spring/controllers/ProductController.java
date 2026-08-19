package org.alexis.spring.controllers;

import org.alexis.spring.configurations.ExternalConfigurations;
import org.alexis.spring.domain.Product;
import org.alexis.spring.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos") // todos los endpoints piden esto adelante por si tenemos distintos controladores
public class ProductController {

    // instancia de clase
    // ProductService productService = new ProductServiceImpl(); // polimorfismo dinamico
    @Autowired
    @Lazy
    // @Qualifier("jsonResourceService") // para indicar que queremos la implementacion de ProductosServiceJSONImpl, si no se pone, Spring busca la implementacion por defecto, que es ProductServiceImpl
    private ProductService productService; // inyeccion de dependencias, Spring se encarga de crear la instancia y pasarla al controlador

    // inyeccion de dependencias de la clase ExternalConfigurations para poder acceder a las propiedades del archivo application.properties
    @Autowired
    private ExternalConfigurations externalConfigurations;

    @GetMapping("/listado")
    public ResponseEntity<?> getProducts() {

        System.out.println("External Configurations: " + externalConfigurations.toString());

        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

}
