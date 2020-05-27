package br.com.springMysql.awesome.repository;

import br.com.springMysql.awesome.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
