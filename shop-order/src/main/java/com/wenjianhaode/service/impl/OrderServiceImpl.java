package com.wenjianhaode.service.impl;

import com.wenjianhaode.dao.OrderDao;
import com.wenjianhaode.domain.po.Order;
import com.wenjianhaode.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }
}
