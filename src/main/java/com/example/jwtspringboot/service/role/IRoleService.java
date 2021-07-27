package com.example.jwtspringboot.service.role;


import com.example.jwtspringboot.model.Role;
import com.example.jwtspringboot.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}