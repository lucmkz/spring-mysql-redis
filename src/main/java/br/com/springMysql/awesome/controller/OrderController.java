package br.com.springMysql.awesome.controller;

import br.com.springMysql.awesome.error.CustomErrorType;
import br.com.springMysql.awesome.model.Order;
import br.com.springMysql.awesome.services.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
        Assert.notNull(order);
        return Optional.ofNullable(orderService.createOrder(order))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
    }

    @ApiOperation(value = "Return a Order by Id", response = Order[].class)
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id){
        Order order = orderService.getOrder(id);
        if(order == null) {
            return new ResponseEntity<>(new CustomErrorType("Order not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a Order infotmations", response = Order[].class)
    @PutMapping(path = "/{id}")
    public ResponseEntity updateOrder(@PathVariable(value = "id") Long id, @RequestBody Order order){

        Assert.notNull(order);
        order.setId(id);
        return Optional.ofNullable(orderService.updateOrder(id, order))
                .map(result -> new ResponseEntity(order, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @ApiOperation(value = "Delete a order by ID", response = Order[].class)
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        Order result = orderService.getOrder(id);
        if(result == null) {
            return new ResponseEntity<>(new CustomErrorType("Order does not exists"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Return a list of orders", response = Order[].class)
    @GetMapping
    public ResponseEntity<?> listAllOrders(){
        return new ResponseEntity<>(orderService.listAllOrders(), HttpStatus.OK);
    }
}
