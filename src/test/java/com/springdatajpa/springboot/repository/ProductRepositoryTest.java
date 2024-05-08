package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
     private  ProductRepository productRepository;
    @Test
    void  saveMethod() {
        //create product object
        Product product = new Product();

        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(10));
        product.setActive(true);
        product.setImageUrl("product1.png");
        //save product
        Product savedObject = productRepository.save(product);

        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }
        @Test
         void updateUsingSaveMethod(){
            //fing or reretrieve an entity by id
             Long id = 1L;
             Product product = productRepository.findById(id).get() ;
            //update entitiy indormation
            product.setName("updated Product 1");
            product.setDescription("updated product 1 desc");
             // save updated entity
            Product savedObject = productRepository.save(product);
            System.out.println(savedObject.toString());

        }

        @Test
        void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product.getName());
        }


}