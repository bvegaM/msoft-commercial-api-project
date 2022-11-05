package com.commercial.api.account;

import com.commercial.api.account.model.User;
import com.commercial.api.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AccountsServicesApplication implements ApplicationRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(AccountsServicesApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = User.builder().username("admin").password(passwordEncoder.encode("admin.123"))
                .build();
        userRepository.save(user);
    }
}
