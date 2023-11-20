package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.UserRegisterEntity;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegisterEntity, String> {

	Optional<UserRegisterEntity> findByEmail(String email);

}
