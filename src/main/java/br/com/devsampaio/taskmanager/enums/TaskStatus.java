package br.com.devsampaio.taskmanager.enums;

public enum TaskStatus {

    DONE("Tarefa feita"),
    ON_PROGRESS("Tarefa em progresso"),
    TO_DO("Tarefa a fazer");

    final String description;

    TaskStatus(String description) {
        this.description = description;
    }
}
