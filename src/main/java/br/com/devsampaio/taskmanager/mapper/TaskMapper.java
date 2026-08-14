package br.com.devsampaio.taskmanager.mapper;

import br.com.devsampaio.taskmanager.dto.TaskRequestDto;
import br.com.devsampaio.taskmanager.dto.TaskResponseDto;
import br.com.devsampaio.taskmanager.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "finishedAt", ignore = true)
    Task toEntity(TaskRequestDto dto);


    TaskResponseDto toDto(Task task);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "finishedAt", ignore = true)
    void updateEntityFromDto(TaskRequestDto dto, @MappingTarget Task task);
}
