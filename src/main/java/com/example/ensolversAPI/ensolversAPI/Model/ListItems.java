package com.example.ensolversAPI.ensolversAPI.Model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class ListItems {
    @Id
    @SequenceGenerator(
            name = "listItems_sequence",
            sequenceName = "listItems_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "listItems_sequence"
    )
    private Long id;
    private String name;
    @CreationTimestamp
    private LocalDateTime date;
    @OneToMany
    private List<Item> list;

    public ListItems() {
    }

    public ListItems(Long id, String name, LocalDateTime date, List<Item> list) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.list = list;
    }

    public ListItems(String name) {
        this.name = name;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
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
