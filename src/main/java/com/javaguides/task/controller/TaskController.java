package com.javaguides.task.controller;

import com.javaguides.task.dto.TaskDto;
import com.javaguides.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    // Standard response wrapper
    private <T> ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message, T data) {
        return new ResponseEntity<>(
                Map.of(
                        "status", status.value(),
                        "message", message,
                        "data", data
                ),
                status
        );
    }

    // Create new task
    @PostMapping
    public ResponseEntity<Map<String, Object>> createTask(@RequestBody TaskDto taskDto) {
        TaskDto savedTask = taskService.createTask(taskDto);
        return buildResponse(HttpStatus.CREATED, "Task created successfully", savedTask);
    }

    // Get task by id
    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> getTaskById(@PathVariable("id") Long taskId) {
        TaskDto taskDto = taskService.getTaskById(taskId);
        return buildResponse(HttpStatus.OK, "Task fetched successfully", taskDto);
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllTasks() {
        List<TaskDto> tasks = taskService.getAllTask();
        return buildResponse(HttpStatus.OK, "Tasks fetched successfully", tasks);
    }

    // Update task
    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> updateTask(
            @PathVariable("id") Long taskId,
            @RequestBody TaskDto updatedTask) {
        TaskDto taskDto = taskService.updateTask(taskId, updatedTask);
        return buildResponse(HttpStatus.OK, "Task updated successfully", taskDto);
    }

    // Delete task
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().body("Task deleted successfully");
    }

}
