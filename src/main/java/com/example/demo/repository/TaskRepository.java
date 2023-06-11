package com.example.demo.repository;

import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getByName(String name);

    @Query("SELECT t FROM Task t WHERE t.name = :name")
    List<Task> getByName2(@Param("name") String name);

    @Query("SELECT t FROM Task t WHERE t.name = :name AND t.status = :status")
    List<Task> getByNameAndStatus(@Param("name") String name, @Param("status") Status status);

}
