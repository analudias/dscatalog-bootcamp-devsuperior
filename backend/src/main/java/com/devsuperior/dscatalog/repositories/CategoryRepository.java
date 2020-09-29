package com.devsuperior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.entities.Category;

@Repository //para registrar a classe como um componente injetável
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	

}
