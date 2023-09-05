package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.Categoria;
import com.gutengmorgen.Roomkless.Entities.DtoCrearCategoria;
import com.gutengmorgen.Roomkless.Repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roomkless")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("categorias")
    public List<Categoria> getAllList(){
        return repository.findAll();
    }

    @GetMapping("count")
    public Long countAll(){
        return repository.count();
    }


    @PostMapping("create")
    public String createCategory(@RequestBody @Valid DtoCrearCategoria parms){
        repository.save(new Categoria(parms));
        return "saved";
    }
}
