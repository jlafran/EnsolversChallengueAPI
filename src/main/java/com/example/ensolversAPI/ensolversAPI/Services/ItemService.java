package com.example.ensolversAPI.ensolversAPI.Services;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import com.example.ensolversAPI.ensolversAPI.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
}
