package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.Categoria.Categoria;
import com.gutengmorgen.Roomkless.Entities.Categoria.DtoCrearCategoria;
import com.gutengmorgen.Roomkless.Entities.Categoria.DtoModificarCategoria;
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

    /**
     * Get all list of all reports
     * @return a list of all reports
     */
    @GetMapping(path = "/list")
    public List<Categoria> getAllList(){
        return repository.findAll();
    }

    /**
     * Create a report
     * @param parms DTO with the specifics parameters
     * @return the Category report
     */
    @PostMapping(path = "/create")
    public Categoria createCategory(@RequestBody @Valid DtoCrearCategoria parms){
        return repository.save(new Categoria(parms));
    }

    /**
     * Update a report of a categori using ID
     * @param id
     * @param parms DTO of a report
     * @return a ResponeEntity of the update Category
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<Categoria> updateCategory(@PathVariable Long id, @RequestBody @Valid DtoModificarCategoria parms){
        Categoria categoria = repository.findById(id).orElse(null);
        if(categoria == null) return ResponseEntity.notFound().build();

        categoria.actualizar(parms);
        repository.save(categoria);

        return ResponseEntity.ok(categoria);
    }

    /**
     * Delete a category using the ID
     * @param id
     * @return a ResponseEntity with noContent
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        Categoria categoria = repository.findById(id).orElse(null);
        if(categoria == null) return ResponseEntity.notFound().build();

        repository.delete(categoria);

        return ResponseEntity.noContent().build();
    }

    /**
     * Get report of a category using ID
     * @param id
     * @return a ResponseEntity of a Category
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Categoria> getIdCategory(@PathVariable Long id){
        Categoria categoria = repository.findById(id).orElse(null);
        if(categoria == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoria);
    }
}
