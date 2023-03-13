package com.impllife.data.jpa;

import com.impllife.data.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT OUTER JOIN FETCH u.addresses LEFT OUTER JOIN FETCH u.orders WHERE u.id = :id")
    Optional<User> findByIdEager(Long id);

    @Query("SELECT u FROM User u LEFT OUTER JOIN FETCH u.addresses LEFT OUTER JOIN FETCH u.orders WHERE u.id > :from OR u.id < :to")
    List<User> findAllEager(Long from, Long to);

    @Query("select u from User u WHERE u.id > :from OR u.id < :to")
    @EntityGraph(attributePaths = {"addresses", "orders.address", "orders.items"})
    List<User> findAll(Long from, Long to);
}