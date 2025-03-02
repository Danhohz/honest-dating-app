package com.danhoh.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

/*
 * Сущность зарегистрированного пользователя ака данные Анкеты на сайте знакомств
 *
 * */

@Data
@Builder
@Table(value = "user", schema = "public")
@AllArgsConstructor
public class User {

    // идентификатор в бд
    private UUID id;

    // Отображаемое имя пользователя
    // на данный момент у нас не будет доп.полей для фамилии и отчества
    // пользователь сам выдирает написать имя, имя и фамилию, или какие-либо левые данные
    private String name;

    // логин, для аунтефикации
    private String login;

    // почта пользователя
    private String email;

    // возраст
    private Byte age;

    // номер телефона пользователя
    private String phone;

    // пароль пользователя в зашифрованном виде
    private String password;

    // описание анкеты
    private String description;

}
