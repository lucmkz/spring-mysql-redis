package br.com.springMysql.Awesome.Controller;

import br.com.springMysql.Awesome.model.Costumer;
import br.com.springMysql.Awesome.model.Order;
import br.com.springMysql.Awesome.model.Product;
import br.com.springMysql.Awesome.services.CostumerService;
import br.com.springMysql.Awesome.services.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Create a new Order", response = Order[].class)
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order){
//        System.out.println(order);
        Assert.notNull(order);
        return Optional.ofNullable(orderService.createOrder(order))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @ApiOperation(value = "Return a list of orders", response = Order[].class)
    @GetMapping
    public ResponseEntity<?> listAllOrders(){
        return new ResponseEntity<>(orderService.listAllOrders(), HttpStatus.OK);
    }
}
