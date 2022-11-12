package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, CustomerRepositoryCustom {
}
