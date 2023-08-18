package com.toDoapp.controller;
import com.toDoapp.dto.TaskDto;
import com.toDoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto) {
        TaskDto addedTask = taskService.addTask(taskDto);
        return new ResponseEntity<>(addedTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        TaskDto task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
       // return new ResponseEntity<>("Task deleted successfully by id : "+id ,HttpStatus.OK);
        return ResponseEntity.ok("Task with ID " + id + " has been successfully deleted.");

    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTaskCompleted(
            @PathVariable Long id,
            @RequestBody TaskDto taskDto) {
        TaskDto updatedTask = taskService.updateTaskCompleted(id, taskDto);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
}
