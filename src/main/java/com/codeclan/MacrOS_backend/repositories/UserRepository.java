package com.codeclan.MacrOS_backend.repositories;

import com.codeclan.MacrOS_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
