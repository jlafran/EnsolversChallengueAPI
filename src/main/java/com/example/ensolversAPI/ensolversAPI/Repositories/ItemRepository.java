package com.example.ensolversAPI.ensolversAPI.Repositories;


import com.example.ensolversAPI.ensolversAPI.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository
        extends JpaRepository <Item,Long> {
}
