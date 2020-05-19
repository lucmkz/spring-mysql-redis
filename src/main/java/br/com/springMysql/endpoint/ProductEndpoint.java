package br.com.springMysql.endpoint;

import br.com.springMysql.error.CustomErrorType;
import br.com.springMysql.model.Product;
import br.com.springMysql.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

/**
 *  Created by Lucas Duarte
 */

@RestController
@RequestMapping("products")
public class ProductEndpoint {
//    private DateUtil dateUtil;
//
//    @Autowired
//    public ProductEndpoint(DateUtil dateUtil) {
//        this.dateUtil = dateUtil;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(Product.productList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id){
        Product product = new Product();
        product.setId(id);
        int index = Product.productList.indexOf(product);

        if(index == -1) {
            return new ResponseEntity<>(new CustomErrorType("Product not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Product.productList.get(index), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product){
        Product.productList.add(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
