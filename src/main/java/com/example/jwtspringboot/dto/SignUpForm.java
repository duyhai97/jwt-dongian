package com.example.jwtspringboot.dto;

import java.util.Set;

public class SignUpForm {
    private String name;
    private String username;
    private String password;
    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String name, String username, String password, Set<String> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
