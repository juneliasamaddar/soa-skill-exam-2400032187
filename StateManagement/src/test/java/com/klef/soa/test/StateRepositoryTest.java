package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.State;
import com.klef.soa.repository.StateRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StateRepositoryTest {

    @Autowired
    private StateRepository repository;

    @Test
    public void testFindAll() {
        List<State> list = repository.findAll();
        assertNotNull(list);
    }

    @Test
    public void testFindById() {
        State state = new State();
        state.setName("Telangana");
        state.setType("State");
        state.setStatus("Active");
        state.setLocation("South India");

        State saved = repository.save(state);

        Optional<State> result = repository.findById(saved.getStateId());
        assertTrue(result.isPresent());

        Optional<State> invalid = repository.findById(-1L);
        assertFalse(invalid.isPresent());
    }

    @Test
    public void testFindByName() {
        State state = new State();
        state.setName("Telangana");
        state.setType("State");
        state.setStatus("Active");
        state.setLocation("South India");

        repository.save(state);

        List<State> result = repository.findByName("Telangana");
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindByType() {
        State state = new State();
        state.setName("Andhra Pradesh");
        state.setType("State");
        state.setStatus("Active");
        state.setLocation("South India");

        repository.save(state);

        List<State> result = repository.findByType("State");
        assertFalse(result.isEmpty());
    }

    @Test
    public void testCount() {
        State state = new State();
        state.setName("Karnataka");
        state.setType("State");
        state.setStatus("Active");
        state.setLocation("South India");

        repository.save(state);

        assertTrue(repository.count() >= 1);
    }

    @Test
    public void testStateDetails() {
        State state = new State();
        state.setName("Kerala");
        state.setType("State");
        state.setStatus("Active");
        state.setLocation("South India");

        State saved = repository.save(state);

        assertNotNull(saved.getStateId());
        assertNotNull(saved.getName());
        assertNotNull(saved.getType());
        assertNotNull(saved.getStatus());
        assertNotNull(saved.getLocation());
    }
}
