package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.Consultas.Consulta;
import com.gutengmorgen.Roomkless.Entities.Consultas.DtoConsulta;
import com.gutengmorgen.Roomkless.Repository.ConsultaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roomkless")
public class ConsultaController {

    @Autowired
    private ConsultaRepo repo;

//    @GetMapping("/consulta")
//    public List<Consulta> list(){
//        return repo.findAllCategoriasConItems();
//    }


}
