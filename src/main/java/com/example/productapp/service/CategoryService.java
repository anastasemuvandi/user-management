package com.example.productapp.service;

import com.example.productapp.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryDTO> findAll();

    CategoryDTO create(CategoryDTO request);

    CategoryDTO update(CategoryDTO request, UUID id);

    void delete(UUID id);

    CategoryDTO findById(UUID id);
}
