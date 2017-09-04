package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
	@Query(value = "SELECT * FROM Users WHERE auth_id = :auth_id", nativeQuery = true)
    public User findByAuthId(@Param("auth_id") String auth_id);
}