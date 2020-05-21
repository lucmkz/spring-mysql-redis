package br.com.springMysql.Awesome.Controller;

import br.com.springMysql.Awesome.services.ProductService;
import br.com.springMysql.Awesome.model.Product;
import br.com.springMysql.Awesome.error.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *  Created by Lucas Duarte
 */

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        Assert.notNull(product);
        return Optional.ofNullable(productService.createProduct(product))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id){
        Product product = productService.getProduct(id);
        if(product == null) {
            return new ResponseEntity<>(new CustomErrorType("Product not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateProduct(@PathVariable(value = "id") Long id, @RequestBody Product product){
        Assert.notNull(product);
        product.setId(id);
        return Optional.ofNullable(productService.updateProduct(id, product))
                .map(result -> new ResponseEntity(HttpStatus.NO_CONTENT))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return Optional.ofNullable(productService.deleteProduct(id))
                .map(result -> new ResponseEntity<>(result, HttpStatus.NO_CONTENT))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<?> listAllProducts(){
        return new ResponseEntity<>(productService.listAllProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudantsByName(@PathVariable String name) {
        return new ResponseEntity<>(productService.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
//        return new ResponseEntity<>(productDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }
}
