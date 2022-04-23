package com.example.ensolversAPI.ensolversAPI.Services;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import com.example.ensolversAPI.ensolversAPI.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void addNewItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists) {
            throw new IllegalStateException(
                    "item with id: " + itemId + " does not exist"
            );
        }
        itemRepository.deleteById(itemId);

    }

    @Transactional
    public void updateItem(Long itemId,
                           String name) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException(
                        "item with id: " + itemId + " doesn't exist"
                ));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(item.getName(), name)) {
            item.setName(name);
        }
    }

    public Optional<Item> getItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists) {
            throw new IllegalStateException(
                    "item with id: " + itemId + " does not exist"
            );
        }
        return itemRepository.findById(itemId);
    }
}
