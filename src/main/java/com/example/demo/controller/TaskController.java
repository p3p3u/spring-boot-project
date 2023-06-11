package com.example.demo.controller;
import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/get")
    public List<Task> getAll () {
        return taskService.getAll();
    }

    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Task task) {
        taskService.update(id, task);
    }

    @GetMapping
    public List<Task> getByName(@RequestParam String name) {
        return taskService.getByName(name);
    }

    @GetMapping("/filter")
    public List<Task> getByNameAndStatus(@RequestParam String name, @RequestParam Status status) {
        return taskService.getByNameAndStatus(name, status);
    }
}
