package com.nxtwave.assignment.respository;

import com.nxtwave.assignment.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<Todo,Integer> {
}
