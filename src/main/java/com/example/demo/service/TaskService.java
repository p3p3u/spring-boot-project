package com.example.demo.service;

import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
     }

    public List<Task> getAll(){
        return (List<Task>) taskRepository.findAll();
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteById(Long id) {
       taskRepository.deleteById(id);
    }

    public Task getById(Long id) {
        Optional<Task> optional = taskRepository.findById(id);
        return optional.orElseGet(Task::new);
    }

    public void update(Long id, Task task) {
        task.setId(id);
        taskRepository.save(task);
    }

    public List<Task> getByName(String name) {
        return taskRepository.getByName2(name);
    }

    public List<Task> getByNameAndStatus(String name, Status status) {
        return taskRepository.getByNameAndStatus(name, status);
    }
}
