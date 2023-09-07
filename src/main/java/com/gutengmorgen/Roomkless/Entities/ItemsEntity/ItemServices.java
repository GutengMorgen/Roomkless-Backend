package com.gutengmorgen.Roomkless.Entities.ItemsEntity;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;
import com.gutengmorgen.Roomkless.Repository.CategoriaRepository;
import com.gutengmorgen.Roomkless.Repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServices {

    private final CategoriaRepository categoriaRepository;
    private final ItemRepository itemRepository;

    public ItemServices(CategoriaRepository categoriaRepository, ItemRepository itemRepository) {
        this.categoriaRepository = categoriaRepository;
        this.itemRepository = itemRepository;
    }

//    @Transactional
    public ResponseEntity<DtoResultItem> saveItem(DtoCrearItem parms){
        Item item = new Item(parms);
        Optional<Categoria> optional = categoriaRepository.findById(parms.categoria_id());

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            item.setCategoria(optional.get());
            return ResponseEntity.ok(new DtoResultItem(itemRepository.save(item)));
        }
    }

    public ResponseEntity<DtoResultItem> updateItem(Item item, DtoModificarItem parms){
        if(parms.categoria_id() == null)
            item.actualizar(parms, null);
        else{
            Optional<Categoria> optional = categoriaRepository.findById(parms.categoria_id());
            if(optional.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            else{
                item.actualizar(parms, optional.get());
            }
        }

        itemRepository.save(item);
        return ResponseEntity.ok(new DtoResultItem(item));
    }
}
