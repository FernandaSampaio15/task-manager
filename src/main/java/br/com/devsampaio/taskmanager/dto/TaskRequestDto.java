package br.com.devsampaio.taskmanager.dto;

import br.com.devsampaio.taskmanager.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskRequestDto (

        @NotBlank(message = "O nome da tarefa é obrigatorio")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String name,
        TaskStatus status,
        @Size(max = 300, message = "A descrição deve ter no máximo 300 caracteres")
        String description

) {}
