package br.com.monteiro.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.monteiro.fullstack.exceptions.ResourceNotFoundException;
import br.com.monteiro.fullstack.model.Category;
import br.com.monteiro.fullstack.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		return optional.orElseThrow( () -> new ResourceNotFoundException(id));
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public Category update(Category category, Long id) {
		category.setId(id);
		return categoryRepository.save(category);
	}
	
	public void delete(Long id) {
		categoryRepository.deleteById(id);;
	}
	
	

}
