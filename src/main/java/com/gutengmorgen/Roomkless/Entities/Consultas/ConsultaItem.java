package com.gutengmorgen.Roomkless.Entities.Consultas;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaItem {
    private String nombre;
    private String link;

    public ConsultaItem(DtoConsultaItem parms){
        this.nombre = parms.nombre();
        this.link = parms.link();
    }
}
