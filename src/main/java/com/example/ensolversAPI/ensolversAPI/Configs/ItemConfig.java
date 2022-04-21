package com.example.ensolversAPI.ensolversAPI.Configs;

import com.example.ensolversAPI.ensolversAPI.Model.Item;
import com.example.ensolversAPI.ensolversAPI.Repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository repository){
        return args -> {
                    Item first = new Item(
                            "First Item"
                    );

                    Item second = new Item(
                    "Second Item"
                    );
                    repository.saveAll(
                            List.of(first,second)
                    );
        };
    }
}
