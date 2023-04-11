package com.example.api.dto;

public record UserDto(
        String name,
        String lastName,
        String birthDate,
        String phone,
        String email) {
}
