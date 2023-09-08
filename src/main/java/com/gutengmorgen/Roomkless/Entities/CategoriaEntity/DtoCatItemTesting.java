package com.gutengmorgen.Roomkless.Entities.CategoriaEntity;

import com.gutengmorgen.Roomkless.Entities.Consultas.DtoConsultaItem;
import org.springframework.data.domain.Page;

import java.util.List;

public record DtoCatItemTesting(
        Long id,
        String nombre,
        Boolean visibilidad,
        List<DtoConsultaItem> consultaItemPage
) {
}
