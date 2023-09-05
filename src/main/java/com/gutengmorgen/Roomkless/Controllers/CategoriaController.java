package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.Categoria;
import com.gutengmorgen.Roomkless.Entities.DtoCrearCategoria;
import com.gutengmorgen.Roomkless.Entities.DtoModificarCategoria;
import com.gutengmorgen.Roomkless.Repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roomkless/categoria")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/count_items")
    public Long countAll(){
        return repository.count();
    }

    @GetMapping(path = "/list")
    public List<Categoria> getAllList(){
        return repository.findAll();
    }

    @PostMapping(path = "/create")
    public Categoria createCategory(@RequestBody @Valid DtoCrearCategoria parms){
        return repository.save(new Categoria(parms));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Categoria> updateCategory(@PathVariable Long id, @RequestBody @Valid DtoModificarCategoria parms){

        Categoria categoria = repository.findById(id).orElse(null);
        if(categoria == null) return ResponseEntity.notFound().build();

        categoria.actualizar(parms);
        repository.save(categoria);

        return ResponseEntity.ok(categoria);
    }
}
