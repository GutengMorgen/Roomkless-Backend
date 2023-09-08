package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;
import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.CategoriaServices;
import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.DtoCatItemTesting;
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
    private final CategoriaServices services;

    public ConsultaController(CategoriaRepository repository, CategoriaServices services) {
        this.repository = repository;
        this.services = services;
    }

    @GetMapping(path = "/consulta")
    public ResponseEntity<Page<?>> getAllList(
            @RequestParam(name = "filter") boolean filter,
            @RequestParam(name = "items", required = false, defaultValue = "false") boolean items,
//            @RequestParam(name = "sizeItems", required = false, defaultValue = "1") int sizeItems,
            @PageableDefault(size = 1) Pageable page){

        Page<?> resultPage;

        if(filter & items){
            //categorias con filtro, items con filtro
            resultPage = repository.findAll(page).map(categoria -> {

                return new DtoCatItemTesting(
                        categoria.getId(),
                        categoria.getNombre(),
                        categoria.getVisibilidad(),
                        services.consultaCustomItemList(categoria));
            });
        }
        else if(!filter & !items){
            //categorias sin filtro
            resultPage = repository.findAll(page).map(DtoConsulta::noFilter_noItems);
        }
        else if(filter & !items){
            //categorias con filtro
            resultPage = repository.findAll(page).map(DtoConsulta::filter_noItems);
        }
        else {
            //categorias sin filtro, items sin filtro
            resultPage = repository.findAll(page).map(categoria -> {
                return new Categoria(
                        categoria.getId(),
                        categoria.getFecha_de_creacion(),
                        categoria.getNombre(),
                        categoria.getVisibilidad(),
                        categoria.getNumero_de_items(),
                        services.consultaItemList(categoria)
                );
            });
        }

        return ResponseEntity.ok(resultPage);
    }
}
