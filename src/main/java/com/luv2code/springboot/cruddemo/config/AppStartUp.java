package com.luv2code.springboot.cruddemo.config;

import com.luv2code.springboot.cruddemo.entity.Users;
import com.luv2code.springboot.cruddemo.service.OmdbApiService;
import com.luv2code.springboot.cruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartUp implements CommandLineRunner {

    private UserService userService;

    private OmdbApiService omdbApiService;

    @Autowired
    public AppStartUp(UserService theuserService ,OmdbApiService omdbApiService ) {
        userService = theuserService;
        this.omdbApiService = omdbApiService;
    }


    @Override
    public void run(String... args) throws Exception {

        if( userService.findAll().isEmpty()) {

            Users user1 = new Users();

            user1.setEmail("admin1@gmail.com");
            user1.setPassword("admin123");
            user1.setUserRole("ROLE_ADMIN");
            user1.setActive((byte) 1);
            user1.setFirstName("admin1");
            user1.setLastName("Fawry");

            Users user2 = new Users();

            user2.setEmail("user1@gmail.com");
            user2.setPassword("user123");
            user2.setUserRole("ROLE_USER");
            user2.setActive((byte) 1);
            user2.setFirstName("user1");
            user2.setLastName("Fawry");

            userService.insert(user1);
            userService.insert(user2);

        }

        if(omdbApiService.findAll().isEmpty()) {
            omdbApiService.insert("Gladiator");
            omdbApiService.insert("Smallville");
            omdbApiService.insert("Drive");
            omdbApiService.insert("Cross");
            omdbApiService.insert("The Boys");
            omdbApiService.insert("The Mentalist");
            omdbApiService.insert("Fallout");
            omdbApiService.insert("Challengers");
            omdbApiService.insert("Beast Games");
            omdbApiService.insert("Goliath");
            omdbApiService.insert("El Dashash");
            omdbApiService.insert("El Harifa 2: El Remontada");
            omdbApiService.insert("Perfect Days");
            omdbApiService.insert("Chicago Fire");
            omdbApiService.insert("All of Us Strangers");
            omdbApiService.insert("Joker");
            omdbApiService.insert("Abigail");
            omdbApiService.insert("The Bear");
            omdbApiService.insert("A Man on the Inside");
            omdbApiService.insert("Zodiac");
            omdbApiService.insert("Hit Man");
            omdbApiService.insert("Avengers: Endgame");
            omdbApiService.insert("Small Things Like These");
        }
    }
}
