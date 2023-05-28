package com.example.demo.controller;
import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {
    List<Task> list = new LinkedList<>();

    public HelloController() {
        list.add(new Task("1", Status.ACTIVE));
        list.add(new Task("2", Status.COMPLETED));
        list.add(new Task("3", Status.ACTIVE));
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/task")
    public List<Task> myTask1(@RequestParam Status status) {

        List<Task> collect = list.stream()
                .filter(t -> t.getStatus().equals(status))
                .collect(Collectors.toList());
//        for (Task el : list) {
//            if (el.getStatus().equals(status)) {
//                return el;
//            }
//        }
        return collect;
    }

    @GetMapping("/task/{name}")
    public Task myTask(@PathVariable String name) {

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)) {
                return list.get(i);
            }
        }
        return null;
    }

    @GetMapping("/tasks")
    public String getList () {
        return list.toString();
    }

    @PostMapping("/task")
    public void createTask(@RequestBody Task task) {
        list.add(task);
    }
}
