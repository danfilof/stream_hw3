package ru.gb.hw3;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {

    private List<Product> items;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>(List.of(
                new Product(1L, "Milk"),
                new Product(2L, "Bread")
        ));
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) {
        items.add(product);
    }
}
