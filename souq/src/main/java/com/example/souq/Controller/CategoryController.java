package com.example.souq.Controller;

import com.example.souq.Class.DTO.CategoryDTO;
import com.example.souq.Service.CategoryService;
import com.example.souq.exeption.CategoryNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<CategoryDTO> getAllCategorys() {
        return categoryService.getAllCategorys();
    }

    @PostMapping("/add")
    public void addCategory(@RequestBody @Valid CategoryDTO category) {
        categoryService.addCategory(category);
    }

    @PutMapping("update/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody @Valid CategoryDTO category) throws CategoryNotFoundException {
        categoryService.updateCategory(id, category);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@RequestParam int id) throws CategoryNotFoundException {
        categoryService.deleteCategory(id);
    }

}
