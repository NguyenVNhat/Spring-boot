package com.apispring.api.controllers;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Roles;
import com.apispring.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("/getall")
    public ResponseEntity<ResponeObject> getall()
    {
        return roleService.getall();
    }
    @PostMapping("/insert")
    public ResponseEntity<ResponeObject> insert(@RequestBody Roles roles)
    {
        return roleService.insert(roles);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponeObject> update(@RequestBody Roles roles)
    {
        return roleService.update(roles);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponeObject> delete(@PathVariable Integer id)
    {
        return roleService.delete(id);
    }
}
