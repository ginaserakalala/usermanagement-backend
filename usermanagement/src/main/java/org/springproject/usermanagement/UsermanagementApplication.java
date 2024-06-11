package org.springproject.usermanagement;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springproject.usermanagement.model.User;
import org.springproject.usermanagement.repository.UserRepository;

import java.util.stream.Stream;
@Slf4j
@SpringBootApplication
public class UsermanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermanagementApplication.class, args);
    }
    @Bean
    CommandLineRunner init(UserRepository userRepository){
        return args -> {
            Stream.of("John","Ororo","Jean","Jubilation").forEach(name ->{
                User user = new User(name, name.toLowerCase() + "@domain.com","password","0584839394");
                userRepository.save(user);
                log.info("saved user: {} ", user);
            });
            log.info("All users:");
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
