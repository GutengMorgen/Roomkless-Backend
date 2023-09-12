package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.*;
import com.gutengmorgen.Roomkless.Entities.Consultas.DtoConsulta;
import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;
import com.gutengmorgen.Roomkless.Repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roomkless/categoria")
public class CategoriaController {

    private final CategoriaRepository repository;
    private final CategoriaServices services;

    public CategoriaController(CategoriaRepository repository, CategoriaServices services) {
        this.repository = repository;
        this.services = services;
    }

    @GetMapping(path = "/count")
    public Long countAll() {
        return repository.count();
    }

    /**
     * Get all list of all reports
     * 
     * @param page paginacion
     * @return a list of all reports
     */
    @GetMapping(path = "/list")
    public ResponseEntity<Page<Categoria>> getAllList(@PageableDefault(size = 1) Pageable page) {
        // return repository.findAll();
        return ResponseEntity.ok(repository.findAll(page));
    }

    /**
     * Create a report
     * 
     * @param parms DTO with the specifics parameters
     * @return the Category report
     */
    @PostMapping(path = "/create")
    public Categoria createCategory(@RequestBody @Valid DtoCrearCategoria parms) {
        return repository.save(new Categoria(parms));
    }

    /**
     * Update a report of a categori using ID
     * 
     * @param id    ide de la categoria
     * @param parms DTO of a report
     * @return a ResponeEntity of the update Category
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<Categoria> updateCategory(@PathVariable Long id,
            @RequestBody @Valid DtoModificarCategoria parms) {
        Categoria categoria = repository.findById(id).orElse(null);
        if (categoria == null)
            return ResponseEntity.notFound().build();

        categoria.actualizar(parms);
        repository.save(categoria);

        return ResponseEntity.ok(categoria);
    }

    /**
     * Delete a category using the ID
     * 
     * @param id id de la categoria
     * @return a ResponseEntity with noContent
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        Categoria categoria = repository.findById(id).orElse(null);
        if (categoria == null)
            return ResponseEntity.notFound().build();

        repository.delete(categoria);

        return ResponseEntity.noContent().build();
    }

    /**
     * Get report of a category using ID
     * 
     * @param id id de la categoria
     * @return a ResponseEntity of a Category
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Categoria> getIdCategory(@PathVariable Long id) {
        Categoria categoria = repository.findById(id).orElse(null);
        if (categoria == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoria);
    }

    /**
     * obtiene una lista de items de una categoria especifica, sin filtros
     * 
     * @param id
     * @param page
     * @param size
     * @return
     */
    @GetMapping(path = "/{id}/items")
    public ResponseEntity<List<Item>> getItemsByCategory(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size) {

        Categoria categoria = repository.findById(id).orElse(null);
        if (categoria == null)
            return ResponseEntity.notFound().build();

//        return ResponseEntity.ok(DtoConsulta.noFilter_LimitItems(categoria,
//                services.limitItems(categoria, page, size)));

        //talvez ponerlo en ItemController, creo que si seria mejor, por la paginacion
        return ResponseEntity.ok(DtoConsulta.testingitems(categoria,
                services.limitItems(categoria, page, size)));
    }
}
