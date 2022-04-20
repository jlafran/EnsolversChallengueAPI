package com.example.ensolversAPI.ensolversAPI.Services;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ItemService {

    public List<Item> getItems() {
        return List.of(
                new Item(
                1L,
                "Work",
                LocalDate.of(2000, Month.JANUARY,2)
                )
        );
    }
}
