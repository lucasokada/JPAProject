package com.jpaproject.demo.repositories;

import com.jpaproject.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
