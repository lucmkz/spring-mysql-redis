package br.com.springMysql.Awesome.endpoint;

import br.com.springMysql.Awesome.Repository.ProductRepository;
import br.com.springMysql.Awesome.model.Product;
import br.com.springMysql.Awesome.error.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Created by Lucas Duarte
 */

@RestController
@RequestMapping("products")
public class ProductEndpoint {

    private final ProductRepository productDAO;

    @Autowired
    public ProductEndpoint(ProductRepository productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(productDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id){
        Product product = productDAO.findOne(id);

        if(product == null) {
            return new ResponseEntity<>(new CustomErrorType("Product not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudantsByName(@PathVariable String name) {
        return new ResponseEntity<>(productDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product){
        return new ResponseEntity<>(productDAO.save(product), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product){
        productDAO.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
