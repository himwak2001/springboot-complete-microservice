package com.app.repository;

import com.app.entity.Greet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetRepository extends JpaRepository<Greet, Integer> {
}
