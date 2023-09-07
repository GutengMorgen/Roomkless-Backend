package com.gutengmorgen.Roomkless.Entities.CategoriaEntity;

import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;
import com.gutengmorgen.Roomkless.Repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServices {

    private final ItemRepository itemRepository;


    public CategoriaServices(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<Item> pageItems(Categoria categoria, Pageable pageable){
        return itemRepository.findByCategoria(categoria, pageable);
    }
}
