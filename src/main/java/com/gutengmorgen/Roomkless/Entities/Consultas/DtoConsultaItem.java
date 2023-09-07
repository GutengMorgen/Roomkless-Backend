package com.gutengmorgen.Roomkless.Entities.Consultas;

import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;

public record DtoConsultaItem(String nombre, String link) {
    public DtoConsultaItem(Item item) {
        this(item.getNombre(), item.getLink());
    }
}
