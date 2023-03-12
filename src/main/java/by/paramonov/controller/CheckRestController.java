package by.paramonov.controller;

import by.paramonov.entity.Order;
import by.paramonov.model.incomeentries.ArgumentEntry;
import by.paramonov.service.impl.ArgumentServiceImpl;
import by.paramonov.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/checks")
public class CheckRestController {
    private final OrderServiceImpl orderService;
    private final ArgumentServiceImpl argumentService;

    @Autowired
    public CheckRestController(OrderServiceImpl orderService, ArgumentServiceImpl argumentService) {
        this.orderService = orderService;
        this.argumentService = argumentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> checkOrder() {
        List<ArgumentEntry> argumentEntries = argumentService
                .parseInputArguments(new String[]{"1-4", "5-5", "6-2", "card-1"});
        Order order = orderService
                .createOrder(argumentEntries);
        ObjectMapper om = new ObjectMapper();
        String view = null;
        try {
            view = om.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(view, HttpStatus.OK);
    }
}
