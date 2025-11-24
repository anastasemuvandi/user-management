package com.example.productapp.repository;

import com.example.productapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
   /* List<Category> findAll();

    Category save(Category category);

    Optional<Category> findById(UUID id);

    void delete(UUID id);*/
}
