//package ru.cataccess.repository;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ru.cataccess.entities.Cat;
//import ru.cataccess.objects.Breed;
//import ru.cataccess.objects.Color;
//
//@Configuration
//public class LoadRepository {
//    private static final Logger log = LoggerFactory.getLogger(LoadRepository.class);
//
//    @Bean
//    CommandLineRunner initRepository(CatRepository repository) {
//        return args -> {
//            log.info("Preloading" + repository.save(new Cat("Barsik", Breed.British, Color.Gray)));
//            log.info("Preloading" + repository.save(new Cat("Muffin", Breed.Norwegian, Color.Orange)));
//        };
//    }
//}
