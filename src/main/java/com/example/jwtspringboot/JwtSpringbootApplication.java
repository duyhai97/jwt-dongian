package com.example.jwtspringboot;

import com.example.jwtspringboot.model.Role;
import com.example.jwtspringboot.model.User;
import com.example.jwtspringboot.service.role.IRoleService;
import com.example.jwtspringboot.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JwtSpringbootApplication {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(JwtSpringbootApplication.class, args);
    }

//    @PostConstruct
//    public void init() {
//        List<User> users = (List<User>) userService.findAll();
//        List<Role> roleList = (List<Role>) roleService.findAll();
//        if (roleList.isEmpty()) {
//            Role roleAdmin = new Role();
//            roleAdmin.setId(1L);
//            roleAdmin.setName("ROLE_ADMIN");
//            roleService.save(roleAdmin);
//            Role roleUser = new Role();
//            roleUser.setId(2L);
//            roleUser.setName("ROLE_USER");
//            roleService.save(roleUser);
//        }
//        if (users.isEmpty()) {
//            Set<Role> roles = new HashSet<>();
//            Role roleUser = new Role();
//            roleUser.setId(2L);
//            roleUser.setName("ROLE_USER");
//
//
////            User users1 = new User();
////            roles.add(roleUser);
////            users1.setUsername("duyhai1");
////            users1.setPassword("123456");
////            users1.setFullName("duy hai");
////            users1.setRoles(roles);
////            userService.save(users1);
//
//        }
//    }


}
