package com.klef.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.State;
import com.klef.soa.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository repository;

    @Override
    public State addState(State state) {
        return repository.save(state);
    }

    @Override
    public List<State> getAllStates() {
        return repository.findAll();
    }

    @Override
    public State getStateById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found with id : " + id));
    }

    @Override
    public State updateState(Long id, State state) {

        State existingState = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found with id : " + id));

        existingState.setName(state.getName());
        existingState.setType(state.getType());
        existingState.setStatus(state.getStatus());
        existingState.setLocation(state.getLocation());
        existingState.setCreatedAt(state.getCreatedAt());
        existingState.setUpdatedAt(state.getUpdatedAt());

        return repository.save(existingState);
    }

    @Override
    public void deleteState(Long id) {

        State state = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found with id : " + id));

        repository.delete(state);
    }

    @Override
    public List<State> getStatesByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<State> getStatesByType(String type) {
        return repository.findByType(type);
    }
}