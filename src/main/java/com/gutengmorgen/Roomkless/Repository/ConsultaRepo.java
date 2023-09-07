package com.gutengmorgen.Roomkless.Repository;

import com.gutengmorgen.Roomkless.Entities.Consultas.Consulta;
import com.gutengmorgen.Roomkless.Entities.Consultas.DtoConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepo extends JpaRepository<Consulta, Long> {
//    @Query("SELECT new com.gutengmorgen.Roomkless.Entities.Consultas.Consulta(new com.gutengmorgen.Roomkless.Entities.Consultas.DtoConsulta(c.id as id, c.nombre as categoria_nombre, new com.gutengmorgen.Roomkless.Entities.Consultas.DtoConsultaItem(i.nombre as nombre, i.link as link))) " +
//            "FROM Categoria c " +
//            "LEFT JOIN Item i ON c.id = i.categoria_id")
//    List<Consulta> findAllCategoriasConItems();
}
