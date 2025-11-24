package com.example.productapp.controller;

import com.example.productapp.dto.CategoryDTO;
import com.example.productapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> list=categoryService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("id") UUID id)
    {
        return ResponseEntity.ok(categoryService.findById(id));
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO request){
        CategoryDTO response=categoryService.create(request);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    private ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO request,@PathVariable("id") UUID id){
        CategoryDTO result=categoryService.update(request,id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Map<String,String>> delete(@PathVariable("id") UUID id){
        categoryService.delete(id);
        return ResponseEntity.ok(Map.of("message","Category Deleted Successfully"));
    }
}
