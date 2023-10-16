package com.bujubanton.transactionmamagement.repository;

import com.bujubanton.transactionmamagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
