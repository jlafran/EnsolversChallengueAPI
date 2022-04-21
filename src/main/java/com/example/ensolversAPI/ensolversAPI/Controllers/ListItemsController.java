package com.example.ensolversAPI.ensolversAPI.Controllers;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import com.example.ensolversAPI.ensolversAPI.Model.ListItems;
import com.example.ensolversAPI.ensolversAPI.Services.ListItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/listItems")
public class ListItemsController {

    private final ListItemsService listItemsService;

    @Autowired
    public ListItemsController(ListItemsService listItemsService) {
        this.listItemsService = listItemsService;
    }

    @GetMapping
    public List<ListItems> getListsItems(){

        return listItemsService.getListsItems();
    }

    @GetMapping(path = "{listItemsId}")
    public Optional<ListItems> getListItems(@PathVariable("listItemsId") Long listItemsId){

        return listItemsService.getListItems(listItemsId);
    }

    @PostMapping
    public void registerListItems(@RequestBody ListItems listItems){

        listItemsService.addNewListItems(listItems);
    }

    @DeleteMapping(path = "{listItemsId}")
    public void  deleteListItems(@PathVariable("listItemsId") Long listItemsId){

        listItemsService.deleteListItems(listItemsId);
    }

    @PutMapping(path = "{listItemsId}")
    public void updateListItems(
            @PathVariable("listItemsId") Long listItemsId,
            @RequestParam(required = false)String name){
        listItemsService.updateListItems(listItemsId,name);
    }


    @GetMapping(path = "{listItemsId}")
    public List<Item> getItems(@PathVariable("listItemsId") Long listItemsId){
        return listItemsService.getItems(listItemsId);
    }

    @PostMapping
    public void addNewItem(@RequestParam(required = true) String name){
        listItemsService.addNewItem(name);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(@PathVariable("itemId") Long itemId) {
        listItemsService.updateItem(itemId);
    }

    @DeleteMapping(path = "{itemId}")
    public void  deleteItem(@PathVariable("itemId") Long itemId){
        listItemsService.deleteItem(itemId);
    }


}
