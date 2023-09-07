package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;
import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.DtoCrearCategoria;
import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.DtoModificarCategoria;
import com.gutengmorgen.Roomkless.Repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/roomkless/categoria")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/count")
    public Long countAll(){
        return repository.count();
    }

    /**
     * Get all list of all reports
     * @param page paginacion
     * @return a list of all reports
     */
    @GetMapping(path = "/list")
    public ResponseEntity<Page<Categoria>> getAllList(@PageableDefault(size = 1) Pageable page){
//        return repository.findAll();
        return ResponseEntity.ok(repository.findAll(page));
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
     * @param id ide de la categoria
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
     * @param id id de la categoria
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
     * @param id id de la categoria
     * @return a ResponseEntity of a Category
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Categoria> getIdCategory(@PathVariable Long id){
        Categoria categoria = repository.findById(id).orElse(null);
        if(categoria == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoria);
    }
}
