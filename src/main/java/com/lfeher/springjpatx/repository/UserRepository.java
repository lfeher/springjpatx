package com.lfeher.springjpatx.repository;

import com.lfeher.springjpatx.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
