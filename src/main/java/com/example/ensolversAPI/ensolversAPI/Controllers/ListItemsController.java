package com.example.ensolversAPI.ensolversAPI.Controllers;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import com.example.ensolversAPI.ensolversAPI.Model.ListItems;
import com.example.ensolversAPI.ensolversAPI.Services.ItemService;
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
    public ListItemsController(ListItemsService listItemsService, ItemService itemService) {
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


    @GetMapping(path = "/{listItemsId}/item")
    public List<Item> getItems(@PathVariable("listItemsId") Long listItemsId){
        return listItemsService.getItems(listItemsId);
    }

    @PostMapping(path = "/{listItemsId}/item")
    public void addNewItem(@PathVariable("listItemsId") Long listItemsId,
    @RequestBody(required = true) Item item){
        listItemsService.addNewItem(listItemsId,item);
    }
    @DeleteMapping(path = "/{listItemsId}/item/{itemId}")
    public void deleteItem(@PathVariable("listItemsId") Long listItemsId,
                           @PathVariable("itemId") Long itemId){
        listItemsService.deleteItem(listItemsId,itemId);
    }

}
