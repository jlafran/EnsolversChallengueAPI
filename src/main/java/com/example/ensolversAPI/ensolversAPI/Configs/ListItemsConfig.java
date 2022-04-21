package com.example.ensolversAPI.ensolversAPI.Configs;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import com.example.ensolversAPI.ensolversAPI.Model.ListItems;
import com.example.ensolversAPI.ensolversAPI.Repositories.ListItemsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ListItemsConfig {

    @Bean
    CommandLineRunner commandLineRunner(ListItemsRepository repository){
        return args -> {
            ListItems first = new ListItems(
                    "First List"
            );
            
            repository.saveAll(
                    List.of(first)
            );
        };
    }
}
