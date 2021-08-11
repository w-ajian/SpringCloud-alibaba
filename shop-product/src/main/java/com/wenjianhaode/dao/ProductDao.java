package com.wenjianhaode.dao;

import com.wenjianhaode.domain.po.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
