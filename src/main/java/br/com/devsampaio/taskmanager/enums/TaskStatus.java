package br.com.devsampaio.taskmanager.enums;

import lombok.Getter;

@Getter
public enum TaskStatus {

    DONE("Tarefa feita"),
    IN_PROGRESS("Tarefa em progresso"),
    TO_DO("Tarefa a fazer");

    final String description;

    TaskStatus(String description) {
        this.description = description;
    }
}
