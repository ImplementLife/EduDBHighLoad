package com.impllife.data.jpa;

import com.impllife.data.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT OUTER JOIN FETCH u.addresses LEFT OUTER JOIN FETCH u.orders WHERE u.id = :id")
    Optional<User> findByIdEager(Long id);

    @Query("SELECT u FROM User u LEFT OUTER JOIN FETCH u.addresses LEFT OUTER JOIN FETCH u.orders")
    List<User> findAllEager(long offset, long limit);

    @Query("SELECT u FROM User u LEFT OUTER JOIN FETCH u.addresses LEFT OUTER JOIN FETCH u.orders")
    Slice<User> findAllEagerSlice(PageRequest pageRequest);

    @Query("select u from User u")
    @EntityGraph(attributePaths = {"addresses", "orders.address", "orders.items"})
    List<User> findAllWithEG(PageRequest pageRequest);

    @Query("select u from User u")
    @EntityGraph(type = LOAD, attributePaths = {"addresses", "orders.address", "orders.items"})
    Slice<User> findAllWithEGOL(long offset, long limit);

    @Query("select u from User u")
    @EntityGraph(attributePaths = {"addresses", "orders.address", "orders.items"})
    Slice<User> findAllWithEGP2(PageRequest page);
}