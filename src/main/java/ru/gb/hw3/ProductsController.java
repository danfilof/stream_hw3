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


  //localhost:8189/market/addProduct?title=Soap
    @PostMapping("/products/addProduct")
    public List<Product> addNewProduct(@RequestParam(name = "title") String title) {
        Long prodId = Long.valueOf(pr.getLastIndex() + 1);
       Product newProd = new Product(prodId,title);
        pr.add(newProd);
        return pr.getItems();
    }

    @DeleteMapping("/218392934")
    public void deleteAll() {

    }

    @DeleteMapping("/products/{id}")
    @ResponseBody
    public List<Product> deleteById(@PathVariable Long id) {
//        Product ProdToDelete = new Product()
//        pr.remove();
        return pr.getItems();
    }
}
