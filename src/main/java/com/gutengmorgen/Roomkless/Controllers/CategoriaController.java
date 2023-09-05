package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.Categoria;
import com.gutengmorgen.Roomkless.Entities.DtoCrearCategoria;
import com.gutengmorgen.Roomkless.Entities.DtoModificarCategoria;
import com.gutengmorgen.Roomkless.Repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roomkless/categoria")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/list")
    public List<Categoria> getAllList(){
        return repository.findAll();
    }

    @GetMapping(path = "/count_items")
    public Long countAll(){
        return repository.count();
    }


    @PostMapping(path = "/create")
    public String createCategory(@RequestBody @Valid DtoCrearCategoria parms){
        repository.save(new Categoria(parms));
        return "saved";
    }

    @PutMapping(path = "/{id}")
    public String updateCategory(@PathVariable Long id, @RequestBody @Valid DtoModificarCategoria parms){

        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("categoria no existe"));

        categoria.actualizar(parms);
        repository.save(categoria);

        return "updated";
    }
}
