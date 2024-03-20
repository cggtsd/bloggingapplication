package cgg.blogapp.bloggingapplication.services;

import java.util.List;

import cgg.blogapp.bloggingapplication.payloads.CategoryRecord;

public interface CategoryService {
    CategoryRecord createCategory(CategoryRecord categoryRecord);

    CategoryRecord updateCategory(CategoryRecord categoryRecord, int id);

    CategoryRecord getCategoryById(int id);

    List<CategoryRecord> getAllCategories();

    void deleteCategory(int id);
}
