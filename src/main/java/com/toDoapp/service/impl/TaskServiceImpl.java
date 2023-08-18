package com.toDoapp.service.impl;


import com.toDoapp.dto.TaskDto;
import com.toDoapp.exception.InvalidInputException;
import com.toDoapp.repository.TaskRepository;
import com.toDoapp.entity.Task;
import com.toDoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        if (isValidTaskDto(taskDto)) {
            Task task = new Task();
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setCompleted(taskDto.isCompleted());
            taskRepository.save(task);

            // Set the generated id in the taskDto before returning
            taskDto.setId(task.getId());

            return taskDto;
        } else {
            throw new InvalidInputException("Invalid task data");
        }
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted()))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.isCompleted());
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        taskRepository.delete(task);
    }

    @Override
    public TaskDto updateTaskCompleted(Long id, TaskDto taskDto) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
        existingTask.setCompleted(taskDto.isCompleted());
        taskRepository.save(existingTask);
        return new TaskDto(existingTask.getId(), existingTask.getTitle(), existingTask.getDescription(), existingTask.isCompleted());
    }

    private boolean isValidTaskDto(TaskDto taskDto) {
        // Implement your validation logic here
        // For example, check if title is not null or empty
        return taskDto.getTitle() != null && !taskDto.getTitle().isEmpty();
    }
}
