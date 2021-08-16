package com.wenjianhaode.dao;

import com.wenjianhaode.domain.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {
}
