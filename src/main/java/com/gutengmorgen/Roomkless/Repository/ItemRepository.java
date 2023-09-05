package com.gutengmorgen.Roomkless.Repository;

import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
