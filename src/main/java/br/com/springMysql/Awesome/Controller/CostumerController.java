package br.com.springMysql.Awesome.Controller;

import br.com.springMysql.Awesome.error.CustomErrorType;
import br.com.springMysql.Awesome.model.Costumer;
import br.com.springMysql.Awesome.model.Product;
import br.com.springMysql.Awesome.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("costumer")
public class CostumerController {
    private final CostumerService costumerService;

    @Autowired
    public CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @PostMapping
    public ResponseEntity<?> createCostumer(@RequestBody Costumer costumer){
        Assert.notNull(costumer);
        return Optional.ofNullable(costumerService.createCostumer(costumer))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCostumerById(@PathVariable("id") Long id){
        Costumer costumer = costumerService.getCostumer(id);
        if(costumer == null) {
            return new ResponseEntity<>(new CustomErrorType("Costumer not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(costumer, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateCostumer(@PathVariable(value = "id") Long id, @RequestBody Costumer costumer){
//        Costumer result = costumerService.getCostumer(id);
//        if(result == null) {
//            return new ResponseEntity<>(new CustomErrorType("Costumer not found"), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(costumerService.updateCostumer(id, costumer), HttpStatus.OK);

        Assert.notNull(costumer);
        costumer.setId(id);
        return Optional.ofNullable(costumerService.updateCostumer(id, costumer))
                .map(result -> new ResponseEntity(costumer, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCostumer(@PathVariable Long id){
        Costumer result = costumerService.getCostumer(id);
        if(result == null) {
            return new ResponseEntity<>(new CustomErrorType("Costumer does not exists"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(costumerService.deleteCostumer(id), HttpStatus.OK);
//        return Optional.ofNullable(productService.deleteProduct(id))
//                .map(result -> new ResponseEntity<>(result, HttpStatus.NO_CONTENT))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//
    @GetMapping
    public ResponseEntity<?> listAllProducts(){
        return new ResponseEntity<>(costumerService.listAllCostumer(), HttpStatus.OK);
    }
//
    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudantsByName(@PathVariable String name) {
        return new ResponseEntity<>(costumerService.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
//        return new ResponseEntity<>(productDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }
}
