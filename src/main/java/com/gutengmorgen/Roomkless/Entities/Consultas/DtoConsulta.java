package com.gutengmorgen.Roomkless.Entities.Consultas;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;
import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;

import java.util.List;


public record DtoConsulta(Long id, String nombre, Boolean visibilidad, List<?> items) {

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

    public static DtoConsulta filter_LimitItems(Categoria c, List<?> items){
        return new DtoConsulta(
                c.getId(),
                c.getNombre(),
                c.getVisibilidad(),
                items
        );
    }

    public static Categoria noFilter_LimitItems(Categoria c, List<Item> items){
        return new Categoria(
                c.getId(),
                c.getFecha_de_creacion(),
                c.getNombre(),
                c.getVisibilidad(),
                c.getNumero_de_items(),
                items
        );
    }

    public static List<Item> testingitems(Categoria c, List<Item> items){
        return items;
    }
}

