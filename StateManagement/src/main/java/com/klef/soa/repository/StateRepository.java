package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByName(String name);

    List<State> findByType(String type);
}