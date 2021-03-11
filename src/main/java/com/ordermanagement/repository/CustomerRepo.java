package com.ordermanagement.repository;

import com.ordermanagement.models.Customers;
import com.ordermanagement.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customers,Long> {
}
