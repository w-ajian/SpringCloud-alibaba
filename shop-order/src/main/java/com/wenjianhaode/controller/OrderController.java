package com.wenjianhaode.controller;

import com.wenjianhaode.domain.po.Order;
import com.wenjianhaode.domain.po.Product;
import com.wenjianhaode.service.OrderService;
import com.wenjianhaode.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductService productService;

    /**
     *  Fegin 整合 ribbon 实现高效率负载和代码简洁开发
     */
    @GetMapping("/order/prod/{pid}")
    public Order oredr(@PathVariable("pid") Integer pid) {

        Product product = productService.findByPid(pid);

        //下单(创建订单)
        Order order = new Order();
        order.setUid(new Random().nextInt(100) + 1);
        order.setUsername("闻健");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(99);
        orderService.createOrder(order);
        return order;
    }

//    @GetMapping("/order/prod/{pid}")
//    public Order oredr(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        ServiceInstance serviceInstance = instances.get(new Random().nextInt(instances.size()));
//        Product product = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(new Random().nextInt(100) + 1);
//        order.setUsername("闻健");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(99);
//        orderService.createOrder(order);
//        return order;
//    }

//    @GetMapping("/order/prod/{pid}")
//    public Order oredr(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(new Random().nextInt(100) + 1);
//        order.setUsername("闻健");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(99);
//        orderService.createOrder(order);
//        return order;
//    }

}
