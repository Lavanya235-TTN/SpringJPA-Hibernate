package com.springdatajpaproject2.repos;

import org.springframework.data.repository.CrudRepository;

import com.springdatajpaproject2.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}

