package com.gutengmorgen.Roomkless.Entities.CategoriaEntity;

import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public record DtoCategriaTesting(
        Long id,
        String nombre,
        Boolean visibilidad,
        Page<Item> itemPage
) {
}
