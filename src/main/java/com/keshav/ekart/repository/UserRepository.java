package com.keshav.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keshav.ekart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
