package me.vega2k.user.restthymeleaf.dao;

import java.util.List;

import me.vega2k.user.restthymeleaf.entity.User;

public interface UserDao {
	public void insert(User user);

	public List<User> readAll();

	public void update(User user);

	public void delete(Long id);

	public User read(Long id);

}
