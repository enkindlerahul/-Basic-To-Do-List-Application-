package com.toDoapp.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    // Update the constructor of TaskDto
    public TaskDto(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }


}
