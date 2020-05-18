package br.com.springMysql.endpoint;

import br.com.springMysql.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

/**
 *  Created by Lucas Duarte
 */

@RestController
@RequestMapping("product")
public class ProductEndpoint {
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Product> listAll(){
        return asList(new Product("Lucas", 1, 2, 3), new Product("Lucass", 2, 3, 4));
    }
}
