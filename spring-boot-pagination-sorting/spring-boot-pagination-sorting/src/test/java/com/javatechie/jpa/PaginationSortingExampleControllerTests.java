package com.javatechie.jpa;

import com.javatechie.jpa.entity.Product;
import com.javatechie.jpa.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaginationSortingExampleControllerTests {


    @Autowired
    private ProductRepository productRepository;


    @Test
    @Order(1)
    public void testCreate(){
        Product p =new Product();

        p.setId(1);
        p.setName("Coca Cola");
        p.setPrice(200L);
        p.setQuantity(20);

        productRepository.save(p);
        //Assertions.assertNotNull(productRepository.findById(12).get());

    }

    @Test
    @Order(2)
    public void testRead(){
        Product product=productRepository.findById(1).get();
        Assertions.assertNotNull("Coca Cola",product.getName());
    }

    @Test
    @Order(3)
    public void testUpdate(){
        Product product=productRepository.findById(1).get();
        product.setPrice(5000);
        productRepository.save(product);
        Assertions.assertNotEquals(4000,productRepository.findById(1).get().getPrice());
    }

    @Test
    @Order(4)
    public void testDelete(){
        productRepository.deleteById(1);
        Assertions.assertFalse(productRepository.existsById(1));
    }

}
