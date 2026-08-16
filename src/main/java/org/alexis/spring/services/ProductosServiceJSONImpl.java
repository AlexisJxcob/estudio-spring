package org.alexis.spring.services;

import org.alexis.spring.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Primary
@Service("jsonResourceService") // esta anotacion indica que es un servicio y lo registra en el contenedor de Spring convirtiendolo en un bean, para que pueda ser inyectado en otros componentes
public class ProductosServiceJSONImpl implements ProductService {

    @Override
    public List<Product> getProducts() {
        List<Product> products;

        try {
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
