package com.javaguides.task.service;

import com.javaguides.task.dto.TaskDto;
import lombok.extern.java.Log;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto taskDto);

    TaskDto getTaskById(Long taskId);

    List<TaskDto> getAllTask();

    List<TaskDto> getAllTasks();

    TaskDto updateTask(Log taskId, TaskDto updateTask);

    TaskDto updateTask(Long taskId, TaskDto updatedTask);

    void deleteTask(Log taskId);

    boolean deleteTask(Long id);
}
