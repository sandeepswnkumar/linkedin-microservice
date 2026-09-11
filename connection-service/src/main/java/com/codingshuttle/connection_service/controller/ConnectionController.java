package com.codingshuttle.connection_service.controller;

import com.codingshuttle.connection_service.entity.Person;
import com.codingshuttle.connection_service.repository.PersonRepository;
import com.codingshuttle.connection_service.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
public class ConnectionController {

    private final ConnectionService connectionService;

    @GetMapping("/{userId}/first-degree")
    public ResponseEntity<List<Person>> getFirstDegreeConnections(@PathVariable Long userid) {
        return ResponseEntity.status(HttpStatus.OK).body(connectionService.getFirstDegreeConnections(userid));
    }
}
