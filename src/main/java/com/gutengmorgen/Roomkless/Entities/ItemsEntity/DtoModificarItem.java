package com.gutengmorgen.Roomkless.Entities.ItemsEntity;

import java.util.Date;

public record DtoModificarItem(
        String nombre,
        String link,
        String link_status,
        String descripcion,
        Boolean visibilidad,
        String etiqueta,
        Long visitas,
        Date ultima_visita,
        Long categoria_id
) { }
