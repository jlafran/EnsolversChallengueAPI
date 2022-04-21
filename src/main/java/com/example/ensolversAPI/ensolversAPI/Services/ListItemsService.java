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

    @Autowired
    public ListItemsService(ListItemsRepository listItemsRepository) {
        this.listItemsRepository = listItemsRepository;
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

    public void addNewItem(String name) {
    }

    public void updateItem(Long itemId) {

    }

    public void deleteItem(Long itemId) {

    }
}

