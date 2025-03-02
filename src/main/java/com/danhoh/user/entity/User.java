package com.danhoh.user.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

/*
 * Сущность зарегистрированного пользователя ака данные Анкеты на сайте знакомств
 * */

@Data
@Builder
@Table(value = "user", schema = "public")
@AllArgsConstructor
public class User {

    @Null
    // идентификатор в бд
    private UUID id;

    @Size(min = 2, max = 50)
    // Отображаемое имя пользователя
    // на данный момент у нас не будет доп.полей для фамилии и отчества
    // пользователь сам выдирает написать имя, имя и фамилию, или какие-либо левые данные
    private String name;

    @Size(min = 2, max = 50)
    // логин, для аунтефикации
    private String login;

    @Email
    // почта пользователя
    private String email;

    @Min(0)
    @Max(100)
    // возраст
    private Byte age;

    @Pattern(regexp = "\\d{8,12}")
    // номер телефона пользователя
    private String phone;

    @Size(min = 8, max = 255)
    // пароль пользователя в зашифрованном виде
    private String password;

    // описание анкеты
    @Size(max = 255)
    private String description;

}
