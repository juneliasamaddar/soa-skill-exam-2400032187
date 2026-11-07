package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.State;

public interface StateService {

    State addState(State state);

    List<State> getAllStates();

    State getStateById(Long id);

    State updateState(Long id, State state);

    void deleteState(Long id);

    List<State> getStatesByName(String name);

    List<State> getStatesByType(String type);
}