package br.com.springMysql.Awesome.Controller;

import br.com.springMysql.Awesome.model.Costumer;
import br.com.springMysql.Awesome.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
