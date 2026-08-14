package br.com.devsampaio.taskmanager.service;

import br.com.devsampaio.taskmanager.dto.TaskRequestDto;
import br.com.devsampaio.taskmanager.dto.TaskResponseDto;
import br.com.devsampaio.taskmanager.exceptions.TaskNotFoundException;
import br.com.devsampaio.taskmanager.mapper.TaskMapper;
import br.com.devsampaio.taskmanager.model.Task;
import br.com.devsampaio.taskmanager.repository.TaskRepository;
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

    public TaskResponseDto getById(Long id) {
        Task task = searchForId(id);
        log.info("Retornando ID {}", id);
        return mapper.toDto(task);
    }

    public TaskResponseDto saveTask(TaskRequestDto dto) {

        Task task = mapper.toEntity(dto);
        Task savedTask = repository.save(task);

        log.info("Salvando tarefa de ID {} no banco de dados", task.getId());

        return mapper.toDto(savedTask);
    }

    public TaskResponseDto updateTask(Long id, TaskRequestDto dto) {
        Task task = searchForId(id);
        mapper.updateEntityFromDto(dto, task);
        log.info("Atualizando todos os campos da tarefa de ID {}", id);
        return mapper.toDto(task);
    }

    private Task searchForId(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.warn("ID {} não encontrado no banco de dados", id);
            return new TaskNotFoundException("ID " + id + " não encontrado no banco de dados");
        } );
    }
}
