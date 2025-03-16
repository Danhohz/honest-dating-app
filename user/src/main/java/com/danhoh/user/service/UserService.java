package com.danhoh.user.service;

import com.danhoh.user.entity.User;
import com.danhoh.user.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    public Mono<User> save(@NotNull User user) {
        return userRepository.save(user);
    }

    public Flux<User> getBy(@NotNull User filterUser) {

        log.debug("Staring building query criteria...");

        Criteria criteria = Criteria.empty();

        if (nonNull(filterUser.getId())) {
            criteria = criteria.and("id").is(filterUser.getId());
        }

        if (nonNull(filterUser.getName())) {
            criteria = criteria.and("name").is(filterUser.getName());
        }

        if (nonNull(filterUser.getLogin())) {
            criteria = criteria.and("login").is(filterUser.getLogin());
        }

        if (nonNull(filterUser.getEmail())) {
            criteria = criteria.and("email").is(filterUser.getEmail());
        }

        if (nonNull(filterUser.getAge())) {
            criteria = criteria.and("age").is(filterUser.getAge());
        }

        if (nonNull(filterUser.getPhone())) {
            criteria = criteria.and("phone").is(filterUser.getPhone());
        }

        if (nonNull(filterUser.getPassword())) {
            criteria = criteria.and("password").is(filterUser.getPassword());
        }

        if (nonNull(filterUser.getDescription())) {
            criteria = criteria.and("description").is(filterUser.getDescription());
        }

        log.debug("Query criteria is {}", criteria);

        return r2dbcEntityTemplate.select(User.class)
                .matching(Query.query(criteria))
                .all();
    }
}
