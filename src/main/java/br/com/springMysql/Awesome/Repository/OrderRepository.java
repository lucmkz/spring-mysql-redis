package br.com.springMysql.Awesome.Repository;

import br.com.springMysql.Awesome.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
