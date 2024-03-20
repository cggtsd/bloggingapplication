package cgg.blogapp.bloggingapplication.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cgg.blogapp.bloggingapplication.entities.Category;
import cgg.blogapp.bloggingapplication.exceptions.ResourceNotFoundException;
import cgg.blogapp.bloggingapplication.payloads.CategoryRecord;
import cgg.blogapp.bloggingapplication.repositories.CategoryRepo;
import cgg.blogapp.bloggingapplication.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepo categoryRepo;
    
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public CategoryRecord createCategory(CategoryRecord categoryRecord) {
        Category savedCategory = this.categoryRepo.save(categoryRecord.category());
        return categoryRecord;
    }

    @Override
    public CategoryRecord updateCategory(CategoryRecord categoryRecord, int id) {
        Category category = this.categoryRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("category ", "category id", id));

        category.setCategoryTitle(categoryRecord.category().getCategoryTitle());
        category.setCategoryDescription(categoryRecord.category().getCategoryDescription());

         this.categoryRepo.save(category);

         return categoryRecord;
    }

    @Override
    public CategoryRecord getCategoryById(int id) {
        Category category = this.categoryRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("category ", "category id", id));

        return new CategoryRecord(category);
    }

    @Override
    public List<CategoryRecord> getAllCategories() {
       return this.categoryRepo.findAll().stream().map(cat->new CategoryRecord(cat)).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(int id) {
        Category category = this.categoryRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("category ", "category id", id));

        this.categoryRepo.delete(category);
    }
    
}
