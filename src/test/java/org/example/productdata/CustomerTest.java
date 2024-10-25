package org.example.productdata;


import org.example.productdata.entities.Customer;
import org.example.productdata.repository.CustomerRepository;
import org.example.productdata.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerTest {

    @Autowired
    CustomerRepository repository;

    @Test
    void contextLoads() {
    }



    @Test
    public void testCreate() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Tom");
        customer.setEmail("tom@tom.com");

        repository.save(customer);
    }

    @Test
    void testRead() {
        Customer customer = repository
                .findById(1)
                .orElse(null);

        assertNotNull(customer);
        assertEquals("Tom", customer.getName());
        System.out.println(">>>>>>>>>>>>>>>> " + customer.getEmail());
    }

    @Test
    void testUpdate() {
        Customer productById = repository
                .findById(1)
                .orElse(null);
        productById.setEmail("tom@tom2.com");

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
}

