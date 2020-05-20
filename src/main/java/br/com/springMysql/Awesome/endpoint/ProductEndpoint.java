package br.com.springMysql.Awesome.endpoint;

import br.com.springMysql.Awesome.ProductServices;
import br.com.springMysql.Awesome.Repository.ProductRepository;
import br.com.springMysql.Awesome.model.Product;
import br.com.springMysql.Awesome.error.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Optional;

/**
 *  Created by Lucas Duarte
 */

@RestController
@RequestMapping("products")
public class ProductEndpoint {

//    private final ProductRepository productDAO;
    private final ProductServices productServices;

    @Autowired
    public ProductEndpoint(ProductServices productServices) {
        this.productServices = productServices;
    }


//    @ResponseBody
//    @Cacheable(value="name", key = "#root.args[0]")

//    @GetMapping
//    public ResponseEntity<?> listAll(){
//        Product product = productServices.listAll();
//        System.out.println("sout teste list");
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }


    /**
     * old Response
     * */
//    @GetMapping(path = "/{id}")
//    public ResponseEntity<?> getProductById(@PathVariable("id") Long id){
//
//        Product product = productDAO.findOne(id);
//
//        if(product == null) {
//            return new ResponseEntity<>(new CustomErrorType("Product not found"), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id){

        Product product = productServices.getProduct(id);
        if(product == null) {
            return new ResponseEntity<>(new CustomErrorType("Product not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);

//        return new ResponseEntity<>(productServices.getProduct(id), HttpStatus.OK);

//        return Optional.ofNullable(productServices.getProduct(id))
//                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


//    @GetMapping(path = "/findByName/{name}")
//    public ResponseEntity<?> findStudantsByName(@PathVariable String name) {
//        System.out.println(name+"name");
//        return new ResponseEntity<>(productDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
//    }
//

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        Assert.notNull(product);
        return Optional.ofNullable(productServices.createProduct(product))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
//        System.out.println("create cache");
//        return new ResponseEntity<>(productServices.createProduct(product), HttpStatus.OK);
    }
//
//    @DeleteMapping(path = "/{id}")
//    public ResponseEntity<?> delete(@PathVariable Long id){
//        productDAO.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<?> update(@RequestBody Product product){
//        System.out.println("teste");
//        productDAO.save(product);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PutMapping
//    public ResponseEntity<?> update(@RequestBody Product product){
//        System.out.println("teste");
//        productDAO.save(product);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
