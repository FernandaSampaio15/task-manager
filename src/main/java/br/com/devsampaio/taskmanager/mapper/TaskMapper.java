package br.com.devsampaio.taskmanager.mapper;

import br.com.devsampaio.taskmanager.dto.TaskRequestDto;
import br.com.devsampaio.taskmanager.dto.TaskRequestPatchDto;
import br.com.devsampaio.taskmanager.dto.TaskResponseDto;
import br.com.devsampaio.taskmanager.model.Task;
import org.mapstruct.*;

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

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "finishedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdateEntityFromDto(TaskRequestPatchDto dto, @MappingTarget Task task);
}
