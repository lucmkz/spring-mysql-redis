package br.com.springMysql.Awesome.services;

import br.com.springMysql.Awesome.Repository.CostumerRepository;
import br.com.springMysql.Awesome.Repository.OrderRepository;
import br.com.springMysql.Awesome.model.Costumer;
import br.com.springMysql.Awesome.model.Order;
import br.com.springMysql.Awesome.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    @CacheEvict(value = "order", key = "#order.getId()")
    public Order createOrder (Order order){

        Order result = null;
        Product product = new Product();
        Product product1 = new Product();
        order.setProduct(Arrays.asList(product, product1));

        if(!orderRepository.exists(order.getId())) {
            result = this.orderRepository.save(order);
        }
        return result;
    }

    @Cacheable(value = "product")
    public Order getOrder(Long id) {
        System.out.println("getProduct cache");
        return this.orderRepository.findOne(id);
    }

    @CacheEvict(value = "listOrders")
    public Iterable<Order> listAllOrders(){
        return orderRepository.findAll();
    }
}
