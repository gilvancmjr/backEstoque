package br.com.monteiro.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.monteiro.fullstack.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {



}
