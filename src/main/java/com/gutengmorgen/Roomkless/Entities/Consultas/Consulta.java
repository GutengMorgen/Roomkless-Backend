package com.gutengmorgen.Roomkless.Entities.Consultas;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    @Id
    private Long id;

    private Long categoria_id;
    private String categoria_nombre;
    @Embedded
    private ConsultaItem item;

    public Consulta(DtoConsulta parms){
        this.categoria_id = parms.id();
        this.categoria_nombre = parms.categoria_nombre();
        this.item = new ConsultaItem(parms.item());
    }
}
