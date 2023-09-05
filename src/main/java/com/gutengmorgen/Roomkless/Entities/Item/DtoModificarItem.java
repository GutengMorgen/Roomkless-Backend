package com.gutengmorgen.Roomkless.Entities.Item;

public record DtoModificarItem(
        String nombre,
        String link,
        String link_status,
        String descripcion,
        Boolean visibilidad,
        String etiqueta) { }
