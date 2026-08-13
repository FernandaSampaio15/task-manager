package br.com.devsampaio.taskmanager.model;

import br.com.devsampaio.taskmanager.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus status;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;


    @PrePersist
    private void create() {
        createdAt = LocalDateTime.now();

        if (status == null) {
            status = TaskStatus.TO_DO;
        }
    }

    @PreUpdate
    private void update() {

        if (TaskStatus.DONE.equals(status) && this.finishedAt == null) {
            finishedAt = LocalDateTime.now();
        }
    }
}
