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
import br.com.monteiro.fullstack.service.CategoryService;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/categories" })
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> finAll() {
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Category category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}

	@PostMapping
	public ResponseEntity<Category> create(@RequestBody Category category) {
		category = categoryService.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId())
				.toUri();
		return ResponseEntity.created(uri).body(category);

	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id) {
		category = categoryService.update(category, id);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(value = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
