package com.example.jwtspringboot.controller;

import com.example.jwtspringboot.dto.SignUpForm;
import com.example.jwtspringboot.jwt.JwtResponse;
import com.example.jwtspringboot.jwt.JwtService;
import com.example.jwtspringboot.model.Role;
import com.example.jwtspringboot.model.User;
import com.example.jwtspringboot.service.role.IRoleService;
import com.example.jwtspringboot.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getFullName(), userDetails.getAuthorities()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> create(@RequestBody SignUpForm signUpForm) {
        User user = new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getPassword());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role roleAdmin = new Role();
                    roleAdmin.setId(1L);
                    roleAdmin.setName("ROLE_ADMIN");
                    roles.add(roleAdmin);
                    break;
                case "user":
                    Role roleUser = new Role();
                    roleUser.setId(2L);
                    roleUser.setName("ROLE_USER");
                    roles.add(roleUser);
            }

        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>( HttpStatus.OK);

    }





}