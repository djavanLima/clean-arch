package br.com.almode.cleanarch.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@FieldDefaults(level = PRIVATE)
public class Usuario {
    UUID id;
    @NonNull
    final String nome;
    @NonNull
    final String cpf;
}
