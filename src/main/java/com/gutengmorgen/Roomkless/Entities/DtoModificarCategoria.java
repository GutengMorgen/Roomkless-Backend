package com.gutengmorgen.Roomkless.Entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoModificarCategoria(
    String nombre,
    Boolean visibilidad,
    Long numero_de_items) { }
