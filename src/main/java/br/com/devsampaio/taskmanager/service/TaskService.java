package br.com.devsampaio.taskmanager.service;

import br.com.devsampaio.taskmanager.mapper.TaskMapper;
import br.com.devsampaio.taskmanager.model.Task;
import br.com.devsampaio.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper mapper;
    private final TaskRepository repository;
}
