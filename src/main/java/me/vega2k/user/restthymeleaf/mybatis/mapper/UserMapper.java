package me.vega2k.user.restthymeleaf.mybatis.mapper;

import java.util.List;

import me.vega2k.user.restthymeleaf.mybatis.vo.User;

public interface UserMapper {
	User selectUserById(Long id);
	List<User> selectUserList();
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(Long id);
}

