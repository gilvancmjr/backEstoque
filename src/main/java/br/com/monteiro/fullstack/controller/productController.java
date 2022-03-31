package br.com.monteiro.fullstack.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.monteiro.fullstack.model.Category;
import br.com.monteiro.fullstack.model.Product;
import br.com.monteiro.fullstack.service.ProductService;
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/product" })
public class productController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> finAll() {
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		return ResponseEntity.ok().body(product);
	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		product = productService.save(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
				.toUri();
		return ResponseEntity.created(uri).body(product);

	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@RequestBody Product product, @PathVariable Long id) {
		product = productService.update(product, id);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(value = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}


}
