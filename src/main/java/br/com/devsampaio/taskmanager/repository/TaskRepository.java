package br.com.devsampaio.taskmanager.repository;

import br.com.devsampaio.taskmanager.enums.TaskStatus;
import br.com.devsampaio.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByNameIgnoreCase(String name);


}
