package com.apispring.api.repository;

import com.apispring.api.models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order ,Integer> {
    Order findByid(Integer id);
    List<Order> findByuserid(Integer userid);
    List<Order> findBybookid(Integer bookid);
    List<Order> findBydateorder(Date dateorder);
    List<Order> findBystatus(Integer status);

}
