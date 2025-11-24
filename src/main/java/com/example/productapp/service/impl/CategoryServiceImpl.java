package com.example.productapp.service.impl;

import com.example.productapp.dto.CategoryDTO;
import com.example.productapp.entity.Category;
import com.example.productapp.repository.CategoryRepository;
import com.example.productapp.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> list=categoryRepository.findAll();
        return list.stream().map(this::convertToCategoryDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO create(CategoryDTO request) {
        Category category=new Category(
                null,
                request.name()
        );
        Category category1=categoryRepository.save(category);
        return convertToCategoryDTO(category1);
    }

    @Override
    public CategoryDTO update(CategoryDTO request, UUID id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Category not found"));
        category.setName(request.name());
        Category category1=categoryRepository.save(category);
        return convertToCategoryDTO(category1);
    }

    @Override
    public void delete(UUID id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Category not found"));
        categoryRepository.delete(category);
    }

    @Override
    public CategoryDTO findById(UUID id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Category not found"));
        return convertToCategoryDTO(category);
    }

    private CategoryDTO convertToCategoryDTO(Category category) {
        return new CategoryDTO(
                category==null?
                null:
                category.getId(),
                category==null?
                        null:
                        category.getName()
        );
    }
}
