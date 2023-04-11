package com.example.api.model;

import java.util.UUID;

import com.example.api.dto.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Users")
@NoArgsConstructor
public class User {

    public User(UserDto person) {
        this.name = person.name();
        this.lastName = person.lastName();
        this.phone = person.phone();
        this.birthDate = person.birthDate();
        this.email = person.email();
    };

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(length = 10, nullable = false)
    private String birthDate;

    @Column(length = 100, nullable = false)
    private String email;

}
