package com.apispring.api.controllers;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Category;
import com.apispring.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/getall")
    public ResponseEntity<ResponeObject> getall(){
        return categoryService.getall();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponeObject> get(@PathVariable Integer id){
        return categoryService.get(id);
    }
    @GetMapping("/getbyname/{name}")
    public ResponseEntity<ResponeObject> getbyname(@PathVariable String name){
        return categoryService.getbycategory(name);
    }
    @GetMapping("/getbyactive/{active}")
    public ResponseEntity<ResponeObject> getbyactive(@PathVariable Boolean active){
        return categoryService.getbyactive(active);
    }
    @GetMapping("/getbook/{categoryID}")
    public ResponseEntity<ResponeObject> getbook(@PathVariable Integer categoryID){
        return categoryService.getbookwithcategoryID(categoryID);
    }
    @PostMapping("/insert")
    public ResponseEntity<ResponeObject> insert(@RequestBody Category category){
        return categoryService.insert(category);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponeObject> update(@RequestBody Category category)
    {
        return categoryService.update(category);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponeObject> delete(@PathVariable Integer id){
        return categoryService.delete(id);
    }
}
