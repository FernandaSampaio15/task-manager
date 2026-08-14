package br.com.devsampaio.taskmanager.service;

import br.com.devsampaio.taskmanager.dto.TaskResponseDto;
import br.com.devsampaio.taskmanager.mapper.TaskMapper;
import br.com.devsampaio.taskmanager.model.Task;
import br.com.devsampaio.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper mapper;
    private final TaskRepository repository;

    public List<TaskResponseDto> getAll() {
        log.info("Retornando todas as tarefas");
        return repository.findAll().stream().map(task -> mapper.toDto(task)).toList();
    }
}
