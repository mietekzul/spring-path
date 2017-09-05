package pl.raziel.spring.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.data.entities.MongoBook;
import pl.raziel.spring.data.repositories.MongoBookRepository;

import java.util.List;

@RestController
public class MongoBookController {

    @Autowired
    private MongoBookRepository mongoBookRepository;

    @GetMapping("mongobooks")
    public ResponseEntity<List<MongoBook>> getMongoBooks() {
        return new ResponseEntity<>(mongoBookRepository.findAll(), HttpStatus.OK);
    }
}
