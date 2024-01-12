package com.minhaempresa.springweb.infrastructure.repositories;

import com.minhaempresa.springweb.infrastructure.models.Customer;
import com.minhaempresa.springweb.infrastructure.models.pks.CustomerPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerPk> {
}
