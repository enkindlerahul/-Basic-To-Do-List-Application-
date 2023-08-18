package com.toDoapp.service;

import com.toDoapp.dto.TaskDto;
import java.util.List;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Long id);
    void deleteTask(Long id);
    TaskDto updateTaskCompleted(Long id, TaskDto taskDto);
}
