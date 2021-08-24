package com.wenjianhaode.service.impl;

import com.wenjianhaode.dao.ProductDao;
import com.wenjianhaode.domain.po.Product;
import com.wenjianhaode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {

        return productDao.findById(pid).get();

    }
}
