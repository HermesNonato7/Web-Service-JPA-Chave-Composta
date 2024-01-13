package com.minhaempresa.springweb.application.services;

import com.minhaempresa.springweb.application.services.exceptions.DatabaseException;
import com.minhaempresa.springweb.application.services.exceptions.ResourceNotFoundException;
import com.minhaempresa.springweb.infrastructure.models.Pizza;
import com.minhaempresa.springweb.infrastructure.repositories.PizzaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
    Esta classe representa os serviços disponíveis para o cadastro da pizza.
*/
@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza pizzaRegistration(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza findById(Long id) {
        Optional<Pizza> optional = pizzaRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public List<Pizza> findAllById(List<Long> id) {
        return pizzaRepository.findAllById(id);
    }


    public Pizza update(Long id, Pizza pizza) {
        try {
            Pizza entity = pizzaRepository.getReferenceById(id);
            updateEntity(entity, pizza);
            return pizzaRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateEntity(Pizza entity, Pizza pizza) {
        entity.setPrice(pizza.getPrice());
        entity.setName(pizza.getName());
    }

    public void deleteById(Long id) {
        try {
            pizzaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}