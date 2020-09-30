package com.devsuperior.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

@Service //tem uma semântica mais apropriada para o que a classe é - poderia ser chamada de @Repository ou @Component
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true) //para garantir a integridade da transação / para não travar o banco de dados numa operação que é somente de leitura
	public List<Category> findAll() {
		return repository.findAll();
	}

}
