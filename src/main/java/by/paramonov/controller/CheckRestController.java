package by.paramonov.controller;

import by.paramonov.service.impl.RestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/checks")
public class CheckRestController {
    private final RestServiceImpl restService;

    @Autowired
    public CheckRestController(RestServiceImpl restService) {
        this.restService = restService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> checkOrder(@RequestParam(value = "item") List<String> items,
                                             @RequestParam(value = "card") Long cardId) {
        String check = restService.check(items, cardId);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }
}
