package com.roadmap.spring_security_jpa.repositorys;

import com.roadmap.spring_security_jpa.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
    Optional<MyUser> findByUserName(String userName);
}
