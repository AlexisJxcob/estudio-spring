package org.alexis.spring.services;

import org.alexis.spring.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service() // esta anotacion indica que es un servicio y lo registra en el contenedor de Spring convirtiendolo en un bean, para que pueda ser inyectado en otros componentes
@ConditionalOnProperty(name = "service.products", havingValue = "list") // esta anotacion indica que este servicio se va a usar si la propiedad service.products tiene el valor list, de lo contrario no se va a registrar en el contenedor de Spring
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
