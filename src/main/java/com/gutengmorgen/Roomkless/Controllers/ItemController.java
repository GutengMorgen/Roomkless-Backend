package com.gutengmorgen.Roomkless.Controllers;

import com.gutengmorgen.Roomkless.Entities.ItemsEntity.DtoCrearItem;
import com.gutengmorgen.Roomkless.Entities.ItemsEntity.DtoModificarItem;
import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;
import com.gutengmorgen.Roomkless.Repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/roomkless/item")
public class ItemController {
    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/count")
    public Long countAllItems(){
        return repository.count();
    }

    @GetMapping(path = "/list")
    public ResponseEntity<Page<Item>> getList(@PageableDefault(size = 2) Pageable page){
//        return repository.findAll();
        return ResponseEntity.ok(repository.findAll(page));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Item> getIdItem(@PathVariable Long id){
        Item item = repository.findById(id).orElse(null);
        if(item == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(item);
    }

    @PostMapping(path = "/create")
    public Item createItem(@Valid @RequestBody DtoCrearItem parms){
        return repository.save(new Item(parms));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @Valid @RequestBody DtoModificarItem parms){
        Item item = repository.findById(id).orElse(null);
        if(item == null) return ResponseEntity.notFound().build();

        item.actualizar(parms);
        repository.save(item);

        return ResponseEntity.ok(item);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long id){
        Item item = repository.findById(id).orElse(null);
        if(item == null) return ResponseEntity.notFound().build();

        repository.delete(item);

        return ResponseEntity.noContent().build();
    }
}
