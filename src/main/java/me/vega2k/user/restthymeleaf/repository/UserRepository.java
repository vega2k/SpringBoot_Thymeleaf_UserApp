package me.vega2k.user.restthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.vega2k.user.restthymeleaf.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByName(String name);
}
