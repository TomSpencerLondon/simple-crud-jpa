package org.example.productdata;

import org.example.productdata.entities.Product;
import org.example.productdata.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.objenesis.SpringObjenesis;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductdataApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void contextLoads() {
    }



    @Test
    public void testCreate() {
        Product product = new Product();
        product.setId(1);
        product.setName("Iphone");
        product.setDesc("Awesome");
        product.setPrice(1000d);

        repository.save(product);
    }

    @Test
    void testRead() {
        Product productById = repository
                .findById(1)
                .orElse(null);

        assertNotNull(productById);
        assertEquals("Iphone", productById.getName());
        System.out.println(">>>>>>>>>>>>>>>> " + productById.getDesc());
    }

    @Test
    void testUpdate() {
        Product productById = repository
                .findById(1)
                .orElse(null);
        productById.setPrice(1200d);

        repository.save(productById);
    }

    @Test
    void testDelete() {
        repository.deleteById(1);
    }

    @Test
    void testCount() {
        System.out.println(">>>>>>>>> Total records: " + repository.count());
    }

    @Test
    void findByName() {
        List<Product> products = repository.findByName("Iwatch");

        products.forEach(p -> System.out.println(p.getPrice()));
    }

    @Test
    void findByNameAndDescription() {
        List<Product> products = repository.findByNameAndDesc("TV", "From Samsung");

        products.forEach(p -> System.out.println(p.getPrice()));
    }

    @Test
    void findByPriceGreaterThan() {
        List<Product> products = repository.findByPriceGreaterThan(1000d);

        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void findByDescContains() {
        List<Product> products = repository.findByDescContains("Apple");

        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void findByPriceBetweeen() {
        List<Product> products = repository.findByPriceBetween(500d, 2500d);

        products.forEach(p -> System.out.println(p.getName()));
    }
}
