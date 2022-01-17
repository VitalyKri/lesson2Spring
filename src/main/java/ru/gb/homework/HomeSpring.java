package ru.gb.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class HomeSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HomeConfiguration.class);

        Random random = new Random();
        Cart cart = context.getBean(Cart.class);
        for (int i = 0; i < 2; i++) {
            cart.addProduct(random.nextInt(5));
        }
        System.out.println(cart.getProducts().toString());
        cart = context.getBean(Cart.class);
        for (int i = 0; i < 2; i++) {
            cart.addProduct(random.nextInt(5));
        }
        System.out.println(cart.getProducts().toString());

    }
}
