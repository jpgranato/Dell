package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.dell.entities.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
