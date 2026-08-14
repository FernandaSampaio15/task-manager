package br.com.devsampaio.taskmanager.exceptions;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String msg) {
        super(msg);
    }
}
