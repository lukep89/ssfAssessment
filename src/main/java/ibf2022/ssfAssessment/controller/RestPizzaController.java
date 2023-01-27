package ibf2022.ssfAssessment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.ssfAssessment.model.Order;
import ibf2022.ssfAssessment.service.PizzaService;

@RestController
@RequestMapping
public class RestPizzaController {
    @Autowired
    private PizzaService pizzaSvr;

    // @PostMapping(path = "/pizza", consumes =
    // MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // public ResponseEntity<String>

    // @GetMapping(value = "{id}")
    // public ResponseEntity<String> getBoardgame(@PathVariable String id) throws
    // IOException {
    // Order result = pizzaSvr.findById(id);

    // if (result == null) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND)
    // .contentType(MediaType.APPLICATION_JSON)
    // .body("");
    // }
    // return ResponseEntity.status(HttpStatus.OK)
    // .contentType(MediaType.APPLICATION_JSON)
    // .body(result.toJSON().toString());
    // }
}
