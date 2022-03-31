package br.com.monteiro.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.monteiro.fullstack.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
