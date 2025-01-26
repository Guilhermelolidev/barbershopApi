package com.example.apibarber.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ServicoDto {

    @NotNull
    @NotNull(message = "Nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @NotNull(message = "Preço é obrigatório")
    @Min(value = 1, message = "O preço deve ser maior que 0")
    private Double preco;
}
