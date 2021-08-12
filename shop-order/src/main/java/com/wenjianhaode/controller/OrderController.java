package com.wenjianhaode.controller;

import com.wenjianhaode.domain.po.Oredr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    //下单--fegin
    @GetMapping("/order/prod/{pid}")
    public Oredr order(@PathVariable("pid") Integer pid) {
        return new Oredr();
    }

}