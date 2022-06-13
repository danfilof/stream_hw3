package ru.gb.hw3;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    private  ProductsRepository pr;

    public ProductsController(ProductsRepository productsRepository) {
        this.pr = productsRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return pr.getItems();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return pr.getItems().stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product product) {
        pr.add(product);
    }

    @DeleteMapping("/218392934")
    public void deleteAll() {

    }
}
