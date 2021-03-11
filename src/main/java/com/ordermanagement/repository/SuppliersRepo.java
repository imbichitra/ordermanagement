package com.ordermanagement.repository;

import com.ordermanagement.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepo extends JpaRepository<Suppliers,Long> {

}
