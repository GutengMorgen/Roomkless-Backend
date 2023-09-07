package com.gutengmorgen.Roomkless.Entities.ItemsEntity;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;
import com.gutengmorgen.Roomkless.Repository.CategoriaRepository;
import com.gutengmorgen.Roomkless.Repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ItemServices {

    private final CategoriaRepository repository;

    public ItemServices(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Item saveItem(DtoCrearItem parms){
        Item item = new Item(parms);
        Optional<Categoria> optional = repository.findById(parms.categoria_id());
        if (optional.isPresent()) {
            item.setCategoria(optional.get());
            return item;
        } else {
            return null;
        }
    }

    public ResponseEntity<DtoResultItem> updateItem(ItemRepository irepository, Item item, DtoModificarItem parms){
//        Item item = new Item();

        Optional<Categoria> optional = repository.findById(parms.categoria_id());
        if(optional.isPresent()){
            item.setCategoria(optional.get());
            item.actualizar(parms);
            irepository.save(item);
            return ResponseEntity.ok(new DtoResultItem(item));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
