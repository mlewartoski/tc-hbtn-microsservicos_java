package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "API Product")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/welcome")
    @ApiOperation(value = "Responsável por retornar uma mensagem de boas vindas.")
    public String welcome(){
        return "BEM VINDO À PRODUCT REST API.";
    }

    @GetMapping("/allProducts")
    @ApiOperation(value = "Responsável por retornar uma lista de produtos.")
    @ApiResponses({
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    public ResponseEntity<List<Product>> allProducts(){
        return ResponseEntity.ok(this.productRepository.getAllProducts());
    }

    @GetMapping("/findProductById/{id}")
    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @ApiResponses({
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    public ResponseEntity<Product> findProductById(Integer id){
        Product product = this.productRepository.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(this.productRepository.getProductById(id));
    }

    @PostMapping("/addProduct")
    @ApiOperation(value = "Responsável por adicionar um produto.")
    @ApiResponses({
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    public ResponseEntity<Product> addProduct(Product product){
        this.productRepository.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/updateProduct")
    @ApiOperation(value = "Responsável por atualizar um produto.")
    @ApiResponses({
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        this.productRepository.updateProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/removeProduct")
    @ApiOperation(value = "Responsável por remover um produto.")
    @ApiResponses({
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    public ResponseEntity<?> removeProduct(@RequestBody Product product){
        this.productRepository.removeProduct(product);
        return ResponseEntity.ok().build();
    }


}
