package com.minhaempresa.springweb.infrastructure.repositories;

import com.minhaempresa.springweb.infrastructure.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}