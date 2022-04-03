package com.example.shop.web;

import com.example.shop.dto.roles.AddRoleDto;
import com.example.shop.dto.roles.RoleItemDto;
import com.example.shop.entities.RoleEntity;
import com.example.shop.mapper.RoleMapper;
import com.example.shop.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    @GetMapping("/")
    public List<RoleItemDto> index() {
        return roleMapper.RolesToRoleItems(roleRepository.findAll());
    }

    @PostMapping("/create")
    public RoleItemDto create(@RequestBody AddRoleDto dto) {
        RoleEntity role = roleMapper.AddRoleDtoToRole(dto);
        roleRepository.save(role);
        return roleMapper.RoleToRoleItemDto(role);
    }
}
