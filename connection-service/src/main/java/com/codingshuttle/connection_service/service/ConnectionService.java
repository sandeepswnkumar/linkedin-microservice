package com.codingshuttle.connection_service.service;

import com.codingshuttle.connection_service.entity.Person;
import com.codingshuttle.connection_service.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConnectionService {
    private final PersonRepository personRepository;

    public List<Person> getFirstDegreeConnections(Long userid) {
        return personRepository.getFirstDegreeConnections(userid);
    }

}
