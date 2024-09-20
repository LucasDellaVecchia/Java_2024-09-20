package com.example.agenda.domain.robo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoboRepository extends JpaRepository<Robo, Long> {
    Page<Robo> findAll(Pageable paginacao);
}
