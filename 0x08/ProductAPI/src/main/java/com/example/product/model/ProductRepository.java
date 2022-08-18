package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return this.list;
    }

    public Product getProductById(Integer id) {
        return list.stream().filter(p -> p.getId().intValue() == id).findFirst().get();
    }

    public void addProduct(Product s) {
        this.list.add(s);
    }

    public void updateProduct(Product s) {
        this.list = this.list.stream().map(product -> {
            if (Objects.equals(product.getId(), s.getId())){
                product = s;
            }
            return product;
        }).collect(Collectors.toList());
    }

    public void removeProduct(Product s) {
        this.list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        this.list.addAll(listOfProducts);
    }
}
