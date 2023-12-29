package com.MiniBanco.MiniBanco.repository;

import com.MiniBanco.MiniBanco.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
