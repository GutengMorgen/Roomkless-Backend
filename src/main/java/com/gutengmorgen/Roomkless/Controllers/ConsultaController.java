package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.Consultas.DtoConsulta;
import com.gutengmorgen.Roomkless.Repository.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/roomkless")
public class ConsultaController {

    private final CategoriaRepository repository;

    public ConsultaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/consulta")
    public ResponseEntity<Page<?>> getAllList(
            @RequestParam(name = "filter") boolean filter,
            @RequestParam(name = "items", required = false, defaultValue = "false") boolean items,
            @PageableDefault(size = 1) Pageable page){
        if(filter & items){
            //categorias con filtro, items con filtro
            return ResponseEntity.ok(repository.findAll(page).map(DtoConsulta::filter));
        }
        else if(!filter & !items){
            //categorias sin filtro
            return ResponseEntity.ok(repository.findAll(page).map(DtoConsulta::noFilter_noItems));
        }
        else if(filter & !items){
            //categorias con filtro
            return ResponseEntity.ok(repository.findAll(page).map(DtoConsulta::filter_noItems));
        }
        else {
            //categorias sin filtro, items sin filtro
            return ResponseEntity.ok(repository.findAll(page));
        }
    }
}
