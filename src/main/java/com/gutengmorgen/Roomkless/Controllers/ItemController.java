package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;
import com.gutengmorgen.Roomkless.Entities.ItemsEntity.*;
import com.gutengmorgen.Roomkless.Repository.ItemRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/roomkless/item")
public class ItemController {
    private final ItemRepository repository;
    private final ItemServices services;

    public ItemController(ItemRepository repository, ItemServices services) {
        this.repository = repository;
        this.services = services;
    }

    @GetMapping(path = "/count")
    public Long countAllItems(){
        return repository.count();
    }

    @GetMapping(path = "/list")
    public ResponseEntity<Page<DtoResultItem>> getList(@PageableDefault(size = 2) Pageable page){
//        return repository.findAll();
        return ResponseEntity.ok(repository.findAll(page).map(DtoResultItem::new));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Item> getIdItem(@PathVariable Long id){
        Item item = repository.findById(id).orElse(null);
        if(item == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(item);
    }

    @PostMapping(path = "/create")
//    @Transactional
    public ResponseEntity<Item> createItem(@Valid @RequestBody DtoCrearItem parms){
//        return repository.save(new Item(parms));
        Item item = services.saveItem(parms);

        if(item != null)
            return ResponseEntity.ok(repository.save(item));
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DtoResultItem> updateItem(@PathVariable Long id, @Valid @RequestBody DtoModificarItem parms){
        Item item = repository.findById(id).orElse(null);
        if(item == null) return ResponseEntity.notFound().build();

        if(parms.categoria_id() == null){
            item.actualizar(parms);
            repository.save(item);

            return ResponseEntity.ok(new DtoResultItem(item));
        }
        else{
            return services.updateItem(repository, item, parms);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long id){
        Item item = repository.findById(id).orElse(null);
        if(item == null) return ResponseEntity.notFound().build();

        repository.delete(item);

        return ResponseEntity.noContent().build();
    }
}
