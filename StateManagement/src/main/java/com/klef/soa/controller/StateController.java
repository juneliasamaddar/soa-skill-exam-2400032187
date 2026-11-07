
package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.dto.StateRequest;
import com.klef.soa.entity.State;
import com.klef.soa.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService service;

    @GetMapping("/")
    public String home() {
        return "State Management Project";
    }

    @PostMapping("/add")
    public ResponseEntity<State> addState(@RequestBody StateRequest request) {

        State state = new State();

        state.setName(request.getName());
        state.setType(request.getType());
        state.setStatus(request.getStatus());
        state.setLocation(request.getLocation());

        State savedState = service.addState(state);

        return new ResponseEntity<>(savedState, HttpStatus.CREATED);
    }

    @GetMapping("/displayall")
    public ResponseEntity<List<State>> getAllStates() {
        return ResponseEntity.ok(service.getAllStates());
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<State> getStateById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStateById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<State> updateState(
            @PathVariable Long id,
            @RequestBody StateRequest request) {

        State state = new State();

        state.setName(request.getName());
        state.setType(request.getType());
        state.setStatus(request.getStatus());
        state.setLocation(request.getLocation());

        State updatedState = service.updateState(id, state);

        return ResponseEntity.ok(updatedState);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteState(@PathVariable Long id) {
        service.deleteState(id);
        return ResponseEntity.ok("State deleted successfully.");
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<State>> getStatesByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getStatesByName(name));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<State>> getStatesByType(@PathVariable String type) {
        return ResponseEntity.ok(service.getStatesByType(type));
    }
}
