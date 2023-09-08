package com.gutengmorgen.Roomkless.Entities.CategoriaEntity;

import com.gutengmorgen.Roomkless.Entities.Consultas.DtoConsultaItem;
import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;
import com.gutengmorgen.Roomkless.Repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServices {

    private final ItemRepository itemRepository;


    public CategoriaServices(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<Item> pageItems(Categoria categoria, Pageable pageable){
        return itemRepository.findByCategoria(categoria, pageable);
    }

    public List<DtoConsultaItem> consultaCustomItemList(Categoria categoria){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Item> itemPage = pageItems(categoria, pageable);

        return itemPage
                .stream()
                .map(DtoConsultaItem::new)
                .toList();
    }

    public List<Item> consultaItemList(Categoria categoria){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Item> itemPage = pageItems(categoria, pageable);

        return itemPage.getContent();
    }
}
