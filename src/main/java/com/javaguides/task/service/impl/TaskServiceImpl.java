package com.javaguides.task.service.impl;

import com.javaguides.task.dto.TaskDto;
import com.javaguides.task.entity.Task;
import com.javaguides.task.mapper.TaskMapper;
import com.javaguides.task.repository.TaskRepository;
import com.javaguides.task.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        try {
            Task task = TaskMapper.mapToTask(taskDto);
            Task savedTask = taskRepository.save(task);
            return TaskMapper.mapToTaskDto(savedTask);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("A task with the title '" + taskDto.getTitle() + "' already exists.");
        }
    }


    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new RuntimeException("Task does not exist with given id: " + taskId)
                );

        return TaskMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTask() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(TaskMapper::mapToTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return List.of();
    }



    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task does not exist with given id: " + taskId));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());

        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }




    @Override
    public TaskDto updateTask(Log taskId, TaskDto updateTask) {
        return null;
    }


//    delete task

    @Override
    public  void  deleteTask(Log taskId) {
        Task task = (Task) taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task does not exist with given id: " + taskId));


        taskRepository.delete((Task) taskId);
    }

    @Override
    public boolean deleteTask(Long id) {
        return false;
    }

}
