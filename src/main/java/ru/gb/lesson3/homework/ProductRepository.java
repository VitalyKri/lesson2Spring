package ru.gb.lesson3.homework;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepository {

    List<Product> products;


    @PostConstruct
    public void init(){
        products = new ArrayList<Product>();
        Random random = new Random();
        String[] food = new String[]{"mean","fish","cookies","apple"};
        for (int i = 0; i < 5; i++) {
            products.add(new Product(i,
                    food[random.nextInt(4)]+"#"+random.nextInt(10),
                    random.nextDouble()*10));
        }
    }


    public List<Product> getProducts() {
        return products;
    }
    public Product getProduct(int id) {
        for (Product product :
                products) {
            if (product.getId()==id){
                return product;
            }
        }
        throw new RuntimeException("элемент не найден");
    }
}
