package me.vega2k.user.restthymeleaf.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.vega2k.user.restthymeleaf.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByName(String name);
}
