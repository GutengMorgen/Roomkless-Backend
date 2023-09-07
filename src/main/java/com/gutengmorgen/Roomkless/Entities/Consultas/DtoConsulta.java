package com.gutengmorgen.Roomkless.Entities.Consultas;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public record DtoConsulta(Long id, String categoria_nombre, Boolean visibilidad, List<DtoConsultaItem> items) {

    public static DtoConsulta filter(Categoria categoria){
        return new DtoConsulta(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getVisibilidad(),
                categoria.getItems().stream().map(DtoConsultaItem::new).collect(Collectors.toList())
        );
    }

    public static DtoConsulta filter_noItems(Categoria categoria){
        return new DtoConsulta(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getVisibilidad(),
                List.of()
        );
    }

    public static Categoria noFilter_noItems(Categoria categoria){
        return new Categoria(
                categoria.getId(),
                categoria.getFecha_de_creacion(),
                categoria.getNombre(),
                categoria.getVisibilidad(),
                categoria.getNumero_de_items(),
                List.of());
    }
}

