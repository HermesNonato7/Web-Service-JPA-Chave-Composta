package com.minhaempresa.springweb.config;

import com.minhaempresa.springweb.infrastructure.models.Customer;
import com.minhaempresa.springweb.infrastructure.models.Pizza;
import com.minhaempresa.springweb.infrastructure.models.Request;
import com.minhaempresa.springweb.infrastructure.models.pks.CustomerPk;
import com.minhaempresa.springweb.infrastructure.repositories.CustomerRepository;
import com.minhaempresa.springweb.infrastructure.repositories.PizzaRepository;
import com.minhaempresa.springweb.infrastructure.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public void run(String... args) throws Exception {
        Pizza pizza = new Pizza("Muzzarela", 30.50);
        Pizza pizza2 = new Pizza("Calabreza", 25.89);
        Pizza pizza3 = new Pizza("Frango com Catupiry", 50.00);
        pizzaRepository.saveAll(Arrays.asList(pizza, pizza2, pizza3));

        CustomerPk customerPk = new CustomerPk("11999999999", "123456789");
        Customer customer = new Customer(customerPk, "Marcos", "Av. Paulista, 1578");
        customerRepository.save(customer);

        Request request = new Request(LocalDateTime.now(ZoneId.of("UTC")), 2, pizza.getPrice(), pizza, customer);
        requestRepository.save(request);
    }
}

