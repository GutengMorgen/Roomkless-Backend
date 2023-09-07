package com.gutengmorgen.Roomkless.Entities.Consultas;

public record DtoConsulta(
        Long id,
        String categoria_nombre,
        DtoConsultaItem item) { }
