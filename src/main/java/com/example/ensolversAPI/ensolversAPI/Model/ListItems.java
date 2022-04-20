package com.example.ensolversAPI.ensolversAPI.Model;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class ListItems {
    private Long id;
    private String name;
    private LocalDate date;
    @OneToMany
    private List <Item> list;

    public ListItems() {
    }

    public ListItems(Long id, String name, LocalDate date, List<Item> list) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.list = list;
    }

    public ListItems(String name, List<Item> list) {
        this.name = name;
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListItems{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", list=" + list +
                '}';
    }
}
