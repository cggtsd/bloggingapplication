package cgg.blogapp.bloggingapplication.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.blogapp.bloggingapplication.payloads.ApiResponse;
import cgg.blogapp.bloggingapplication.payloads.CategoryRecord;
import cgg.blogapp.bloggingapplication.services.CategoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryRecord> createCategory(@Valid @RequestBody CategoryRecord categoryRecord){
        CategoryRecord addedCategory = this.categoryService.createCategory(categoryRecord);
        return new ResponseEntity<>(addedCategory,HttpStatus.CREATED);
    }


    @PutMapping("/{catId}")
    public ResponseEntity<CategoryRecord> updateCategory(@Valid @RequestBody CategoryRecord categoryRecord,@PathVariable int catId){
              CategoryRecord updatedCategory = this.categoryService.updateCategory(categoryRecord,catId);
              return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryRecord> getCategoryById(@PathVariable int catId){
            CategoryRecord categoryById = this.categoryService.getCategoryById(catId);
            return ResponseEntity.ok(categoryById);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryRecord>> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int catId){
         this.categoryService.deleteCategory(catId);
         return new ResponseEntity<>(new ApiResponse("Category is deleted successfully !!",true),HttpStatus.OK);
    }
}
