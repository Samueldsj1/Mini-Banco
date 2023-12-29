package com.MiniBanco.MiniBanco.Domain.repository;

import com.MiniBanco.MiniBanco.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
