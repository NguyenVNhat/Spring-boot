package com.apispring.api.service;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Roles;
import com.apispring.api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public ResponseEntity<ResponeObject> getall()
    {
        List<Roles> roles = roleRepository.findAll();
        return roles.isEmpty()?
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Failed to get list role","")
            )
        :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("TRUE","Success to get list role",roles)
                );
    }
    public ResponseEntity<ResponeObject> insert(Roles newrole)
    {
        Roles roles = roleRepository.findByid(newrole.getId());
        if(roles == null)
        {
            roleRepository.save(newrole);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success to insert new role",roles)
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Failed to insert new role","")
            );
        }
    }
    public ResponseEntity<ResponeObject> update(Roles newrole)
    {
        Roles roles = roleRepository.findByid(newrole.getId());
        if(roles != null)
        {
            roles.setRoles(newrole.getRoles());
            roleRepository.save(roles);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success to update role",roles)
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Failed to update role","")
            );
        }
    }
    public ResponseEntity<ResponeObject> delete(Integer id)
    {
        Roles roles = roleRepository.findByid(id);
        if(roles != null)
        {
            roleRepository.delete(roles);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success to delete role",roles)
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Failed to delete role","")
            );
        }
    }
}
