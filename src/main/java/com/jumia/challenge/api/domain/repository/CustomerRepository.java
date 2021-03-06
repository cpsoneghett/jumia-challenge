package com.jumia.challenge.api.domain.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumia.challenge.api.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, Serializable {

}
