package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
