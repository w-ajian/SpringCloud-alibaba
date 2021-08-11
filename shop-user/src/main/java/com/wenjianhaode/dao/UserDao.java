package com.wenjianhaode.dao;

import com.wenjianhaode.domain.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
