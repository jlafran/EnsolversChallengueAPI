package com.example.ensolversAPI.ensolversAPI.Controllers;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import com.example.ensolversAPI.ensolversAPI.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {

        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems(){

        return itemService.getItems();
    }

    @GetMapping(path = "{listItemsId}")
    public Optional<Item> getItem(@PathVariable("listItemsId") Long listItemsId){

        return itemService.getItem(listItemsId);
    }


    @PostMapping
    public void registerItem(@RequestBody Item item){
        itemService.addNewItem(item);
    }

    @DeleteMapping(path = "{itemId}")
    public void  deleteItem(@PathVariable("itemId") Long itemId){
        itemService.deleteItem(itemId);
    }

    @PutMapping(path = "item/{itemId}")
    public void updateItem(
            @PathVariable("itemId") Long itemId,
            @RequestParam(required = false)String name){
        itemService.updateItem(itemId,name);
    }
}
