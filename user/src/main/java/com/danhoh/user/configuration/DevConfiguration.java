package com.danhoh.user.configuration;

import com.danhoh.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
@Profile("dev")
@RequiredArgsConstructor
public class DevConfiguration {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        log.info("DEV: Clearing up database...");
        userRepository.deleteAll()
                .block();
        log.info("DEV: Database has been cleared.");
    }
}
