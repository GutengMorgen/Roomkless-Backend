package com.gutengmorgen.Roomkless.Repository;

import com.gutengmorgen.Roomkless.Entities.Categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
