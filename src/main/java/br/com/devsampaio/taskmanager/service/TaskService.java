package br.com.devsampaio.taskmanager.service;

import br.com.devsampaio.taskmanager.dto.TaskRequestDto;
import br.com.devsampaio.taskmanager.dto.TaskRequestPatchDto;
import br.com.devsampaio.taskmanager.dto.TaskResponseDto;
import br.com.devsampaio.taskmanager.exceptions.TaskNotFoundException;
import br.com.devsampaio.taskmanager.mapper.TaskMapper;
import br.com.devsampaio.taskmanager.model.Task;
import br.com.devsampaio.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper mapper;
    private final TaskRepository repository;

    @Transactional(readOnly = true)
    public List<TaskResponseDto> getAll() {
        log.info("Retornando todas as tarefas");
        return repository.findAll().stream().map(task -> mapper.toDto(task)).toList();
    }

    @Transactional(readOnly = true)
    public TaskResponseDto getById(Long id) {
        Task task = searchForId(id);
        log.info("Retornando ID {}", id);
        return mapper.toDto(task);
    }

    @Transactional
    public TaskResponseDto saveTask(TaskRequestDto dto) {

        Task task = mapper.toEntity(dto);

        log.info("Salvando tarefa de ID {} no banco de dados", task.getId());

        return mapper.toDto(task);
    }

    @Transactional
    public TaskResponseDto updateTask(Long id, TaskRequestDto dto) {
        Task task = searchForId(id);
        mapper.updateEntityFromDto(dto, task);
        log.info("Atualizando todos os campos da tarefa de ID {}", id);
        return mapper.toDto(task);
    }

    @Transactional
    public TaskResponseDto parcialUpdateTask(Long id, TaskRequestPatchDto dto) {

        Task task = searchForId(id);

        mapper.parcialUpdateEntityFromDto(dto, task);

        log.info("Atualizando campos específicos da tarefa de ID {}", id);

        return mapper.toDto(task);
    }

    @Transactional
    public void delete(Long id) {

        Task task = searchForId(id);
        repository.delete(task);
        log.info("Deletando tarefa de ID {}", id);
    }

    private Task searchForId(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.warn("ID {} não encontrado no banco de dados", id);
            return new TaskNotFoundException("ID " + id + " não encontrado no banco de dados");
        } );
    }
}
