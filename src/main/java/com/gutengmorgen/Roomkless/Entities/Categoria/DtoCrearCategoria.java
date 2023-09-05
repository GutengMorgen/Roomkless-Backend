package com.gutengmorgen.Roomkless.Entities.Categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DtoCrearCategoria(
        @NotNull
        Date fecha_de_creacion,
        @NotBlank
        String nombre,
        @NotNull
        Boolean visibilidad) { }
