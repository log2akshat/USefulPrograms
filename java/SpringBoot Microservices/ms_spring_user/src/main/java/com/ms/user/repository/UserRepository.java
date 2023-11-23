package com.ms.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.user.entity.UserRegisterEntity;

@Repository
public interface UserRepository extends JpaRepository<UserRegisterEntity, Integer> {

}
