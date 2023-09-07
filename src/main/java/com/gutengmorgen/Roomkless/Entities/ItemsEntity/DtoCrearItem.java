package com.gutengmorgen.Roomkless.Entities.ItemsEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DtoCrearItem(
        @NotNull
        Date fecha_de_creacion,
        @NotBlank
        String nombre,
        @NotBlank
        String link,
        @NotBlank
        String link_status,
        @NotBlank
        String descripcion,
        @NotNull
        Boolean visibilidad,
        @NotBlank
        String etiqueta,
        @NotNull
        Date ultima_visita
//        @NotNull
//        Long categoria_id
) { }
