package ru.gb.lesson3.homework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    List<Product> products;


    // заполняется через Spring !4
    private final ProductRepository repository;

    public Cart(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product.id,product);
    }


    public List<Product> allProducts() {
        return products;
    }

    public Product getProductById(Integer id){
        return products.get(id);
    }
}
