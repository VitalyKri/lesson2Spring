package ru.gb.homework;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Scope("prototype")
public class Cart {

    List<Product> products;

    // заполняется через Spring !4
    private final ProductRepository repository;

    public Cart(ProductRepository repository) {
        this.repository = repository;
    }


    // заполняется через Spring !1
    //@Autowired
    //private ProductRepository repository;

    // заполняется через Spring !2
    //private ProductRepository repository;
    //@Autowired
    //    public Cart(ProductRepository repository) {
    //        this.repository = repository;
    //    }

    // заполняется через Spring !3
    //@Autowired
    //    public void setRepository(ProductRepository repository) {
    //        this.repository = repository;
    //    }

    @PostConstruct
    public void init() {
        products = new ArrayList<Product>();
    }

    public void addProduct(int id) {
        Product product = repository.getProduct(id);
        products.add(product);
    }


    public List<Product> getProducts() {
        return products;
    }
}
