package com.wenjianhaode.service;

import com.alibaba.fastjson.JSON;
import com.wenjianhaode.domain.po.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "shop-user", topic = "order-topic")
public class SmsService implements RocketMQListener<Order> {

    public void onMessage(Order order) {
        log.info("收到一个订单信息{},接下来发送短信", JSON.toJSONString(order));
    }

}
