package com.wenjianhaode.dao;

import com.wenjianhaode.domain.po.Oredr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Oredr, Long> {
}
