package br.com.devsampaio.taskmanager.dto;

import br.com.devsampaio.taskmanager.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponseDto (
        Long id,
        String name,
        TaskStatus status,
        String description,
        LocalDateTime createdAt,
        LocalDateTime finishedAt
) {}
