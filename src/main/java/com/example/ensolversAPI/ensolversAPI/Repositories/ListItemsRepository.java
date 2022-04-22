package com.example.ensolversAPI.ensolversAPI.Repositories;

import com.example.ensolversAPI.ensolversAPI.Model.ListItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListItemsRepository
        extends JpaRepository<ListItems,Long> {
}
