package com.apispring.api.service;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Book;
import com.apispring.api.models.Category;
import com.apispring.api.repository.BookRepository;
import com.apispring.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BookRepository bookRepository;
    public ResponseEntity<ResponeObject> getall(){
        List<Category> categories = categoryRepository.findAll();
        return  categories.isEmpty()?
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False","Can't get all category","")
            )
        : ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("True","Success get all category",categories)
                );
    }
    public ResponseEntity<ResponeObject> getbookwithcategoryID(Integer category_id){
        List<Book> books = bookRepository.findBycategoryId(category_id);
        return books.isEmpty()?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("False","Can't get book with category_id = "+category_id,""))
                :   ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("True","Success to get book with category_id = "+category_id,books));
    }
    public  ResponseEntity<ResponeObject> get(Integer id){
        Category categories = categoryRepository.findByid(id);
        if(categories == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get category with id = "+id, "")
            );
        }
        else{
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success get category with id = "+id,categories)
            );
        }
    }
    public  ResponseEntity<ResponeObject> getbycategory(String name){
        Category categories = categoryRepository.findBycategory(name);
        if(categories == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get category with name = "+name, "")
            );
        }
        else{
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success get category with name = "+name,categories)
            );
        }
    }
    public  ResponseEntity<ResponeObject> getbyactive(Boolean active){
        List<Category> categories = categoryRepository.findByactive(active);
        if(categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get category with active = "+active, "")
            );
        }
        else{
            System.out.println(categories.size());
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success get category with active = "+active,categories)
            );
        }
    }
    public ResponseEntity<ResponeObject> insert(Category newcategory){
        Category category = categoryRepository.findByid(newcategory.getId());
        if(category != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't insert new category", "")
            );
        }
        else{
            categoryRepository.save(newcategory);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success insert new category",newcategory)
            );
        }
    }
    public ResponseEntity<ResponeObject> update(Category newcategory){
        Category category = categoryRepository.findByid(newcategory.getId());
        if(category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't update new category", "")
            );
        }
        else{
            category.setActive(newcategory.getActive());
            category.setCategory(newcategory.getCategory());
            categoryRepository.save(category);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success update new category",newcategory)
            );
        }
    }
    public ResponseEntity<ResponeObject> delete(Integer id){
        Category category = categoryRepository.findByid(id);
        if(category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't delete category with id = "+id , "")
            );
        }
        else{
           categoryRepository.delete(category);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success delete category with id = "+id ,category)
            );
        }
    }
}
