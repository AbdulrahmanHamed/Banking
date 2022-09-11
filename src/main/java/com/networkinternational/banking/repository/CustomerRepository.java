package com.networkinternational.banking.repository;

import com.networkinternational.banking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
    List<Customer> findAll();

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
    Optional<Customer> findById(Long aLong);
}
