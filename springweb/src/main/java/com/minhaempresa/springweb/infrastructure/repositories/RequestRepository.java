package com.minhaempresa.springweb.infrastructure.repositories;

import com.minhaempresa.springweb.infrastructure.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
