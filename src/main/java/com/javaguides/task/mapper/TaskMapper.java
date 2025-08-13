package com.javaguides.task.mapper;

import com.javaguides.task.dto.TaskDto;
import com.javaguides.task.entity.Task;

public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task) {
        return  new  TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription()
        );
    }

    public  static Task mapToTask(TaskDto taskDto) {
        return  new  Task(
            taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getDescription()
        );
    }

}
