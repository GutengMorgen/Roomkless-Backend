package com.gutengmorgen.Roomkless.Entities.ItemsEntity;

import java.util.Date;

public record DtoResultItem(
        Long id,
        Date fecha_de_creacion,
        String nombre,
        String link,
        String link_status,
        String descripcion,
        Boolean visibilidad,
        String etiqueta,
        Long visitas,
        Date ultima_visita,
        Long categoria_id
) {

    public DtoResultItem(Item item){
        this(item.getId(), item.getFecha_de_creacion(), item.getNombre(),
                item.getLink(), item.getLink_status(), item.getDescripcion(),
                item.getVisibilidad(), item.getEtiqueta(), item.getVisitas(),
                item.getUltima_visita(), item.getCategoria().getId()
        );
    }
}
