package com.gutengmorgen.Roomkless.Repository;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

//@NonNullApi
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
//    @Override
//    Page<Categoria> findAll(Pageable page);
}
