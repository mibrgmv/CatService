//package ru.owneraccess.repository;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ru.owneraccess.entity.Owner;
//
//import java.time.LocalDate;
//
//@Configuration
//public class LoadRepository {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadRepository.class);
//
//    @Bean
//    CommandLineRunner initRepository(OwnerRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new Owner("Petya", LocalDate.of(2000, 10, 10))));
//            log.info("Preloading " + repository.save(new Owner("Vova", LocalDate.of(1997, 5, 15))));
//        };
//    }
//}
