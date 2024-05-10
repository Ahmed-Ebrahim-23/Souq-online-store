package com.example.souq.Service;

import com.example.souq.Class.DTO.CategoryDTO;
import com.example.souq.Model.Entity.Category;
import com.example.souq.Model.Repo.CategoryRepo;
import com.example.souq.exeption.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.souq.Class.DTO.CategoryDTO.toCategoryDTOList;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<CategoryDTO> getAllCategorys() {
        List<Category> categorys = categoryRepo.findAll();
        return toCategoryDTOList(categorys);
    }

    public void addCategory(CategoryDTO category) {
        categoryRepo.save(Category.toCategory(category));
    }

    public void updateCategory(int id, CategoryDTO updatedCategory) throws CategoryNotFoundException {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new CategoryNotFoundException("The category with id: " + id + " is not found"));

        category.setName(updatedCategory.getName());

        categoryRepo.save(category);
    }


    public void deleteCategory(int id) throws CategoryNotFoundException {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new CategoryNotFoundException("The category with id: " + id + " is not found"));
        categoryRepo.deleteById(id);
    }
}
