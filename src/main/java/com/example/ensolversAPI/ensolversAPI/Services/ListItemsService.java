package com.example.ensolversAPI.ensolversAPI.Services;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import com.example.ensolversAPI.ensolversAPI.Model.ListItems;
import com.example.ensolversAPI.ensolversAPI.Repositories.ListItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ListItemsService {

    private final ListItemsRepository listItemsRepository;
    private final ItemService itemService;

    @Autowired
    public ListItemsService(ListItemsRepository listItemsRepository, ItemService itemService) {
        this.listItemsRepository = listItemsRepository;
        this.itemService = itemService;
    }

    public List<ListItems> getListsItems() {
        return listItemsRepository.findAll();
    }

    public Optional<ListItems> getListItems(Long listItemsId) {
        boolean exists = listItemsRepository.existsById(listItemsId);
        if(!exists){
            throw new IllegalStateException(
                    "List of Items with id: " + listItemsId + " doesn't exist"
            );
        }
        return listItemsRepository.findById(listItemsId);
    }

    public void addNewListItems(ListItems listItems) {
        System.out.println(listItems);
        listItemsRepository.save(listItems);
    }

    public void deleteListItems(Long listItemsId) {
        boolean exists = listItemsRepository.existsById(listItemsId);
        if(!exists){
            throw new IllegalStateException(
                    "List of Items with id: " + listItemsId + " doesn't exist"
            );
        }
        listItemsRepository.deleteById(listItemsId);
    }

    @Transactional
    public void updateListItems(Long listItemsId, String name) {
        ListItems listItems= listItemsRepository.findById(listItemsId)
                .orElseThrow(()-> new IllegalStateException(
                        "List of Items with id: " + listItemsId + " doesn't exist"
                ));

        if (name!=null &&
                name.length()>0 &&
                !Objects.equals(listItems.getName(),name)){
            listItems.setName(name);
        }
    }

    public List<Item> getItems(Long listItemsId) {
        ListItems listItems=listItemsRepository.findById(listItemsId)
                .orElseThrow(()-> new IllegalStateException(
                "List of Items with id: " + listItemsId + " doesn't exist"
        ));

        return listItems.getList();
    }
    @Transactional
    public void addNewItem(Long listItemsId, Item item) {
        ListItems listItems=listItemsRepository.findById(listItemsId)
                .orElseThrow(()-> new IllegalStateException(
                        "List of Items with id: " + listItemsId + " doesn't exist"
                ));

        if (item.getName()!=null &&
                item.getName().length()>0){

            itemService.addNewItem(item);

            List<Item> newList= listItems.getList();
            newList.add(item);
            listItems.setList(newList);
        }

    }

    @Transactional
    public void deleteItem(Long listItemsId, Long itemId) {
        ListItems listItems=listItemsRepository.findById(listItemsId)
                .orElseThrow(()-> new IllegalStateException(
                        "List of Items with id: " + listItemsId + " doesn't exist"
                ));
        List<Item> newList= listItems.getList();
        newList.removeIf(item -> item.getId()==itemId);
        listItems.setList(newList);
        itemService.deleteItem(itemId);
    }
}

