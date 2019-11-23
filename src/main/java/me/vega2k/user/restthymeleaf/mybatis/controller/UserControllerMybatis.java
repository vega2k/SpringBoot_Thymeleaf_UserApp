package me.vega2k.user.restthymeleaf.mybatis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import me.vega2k.user.restthymeleaf.mybatis.dao.UserDao;
import me.vega2k.user.restthymeleaf.mybatis.vo.User;

@Controller
public class UserControllerMybatis {
	@Autowired
	UserDao userDao;
	
	@GetMapping("/index_mybatis")
	public String index(Model model) {
		model.addAttribute("users", userDao.readAll());
		return "mybatis/index";
	}
	
	@GetMapping("/signup_mybatis")
    public String showSignUpForm(User user) {
        return "mybatis/add-user";
    }
    
    @PostMapping("/adduser_mybatis")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "mybatis/add-user";
        }
        System.out.println("=====> " + user);
        userDao.insert(user);
        model.addAttribute("users", userDao.readAll());
        return "mybatis/index";
    }
    
    @GetMapping("/edit_mybatis/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userDao.read(id);
        if(user == null)
        	new IllegalArgumentException("Invalid user Id:" + id);
        model.addAttribute("user", user);
        return "mybatis/update-user";
    }
    
    @PostMapping("/update_mybatis/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "mybatis/update-user";
        }
        
        userDao.update(user);
        model.addAttribute("users", userDao.readAll());
        return "mybatis/index";
    }
    
    @GetMapping("/delete_mybatis/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userDao.read(id);
        if(user == null)
        	new IllegalArgumentException("Invalid user Id:" + id);
        userDao.delete(id);
        model.addAttribute("users", userDao.readAll());
        return "mybatis/index";
    }
}
