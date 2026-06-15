package com.yanmaia12.ecommerce.repository;

import com.yanmaia12.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
