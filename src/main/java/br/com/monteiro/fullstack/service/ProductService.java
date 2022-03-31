package br.com.monteiro.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.monteiro.fullstack.exceptions.ResourceNotFoundException;
import br.com.monteiro.fullstack.model.Product;
import br.com.monteiro.fullstack.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		return optional.orElseThrow( () -> new ResourceNotFoundException(id));
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Product update(Product product, Long id) {
		product.setId(id);
		return productRepository.save(product);
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}

}
