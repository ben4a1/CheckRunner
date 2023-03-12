package by.paramonov.controller;

import org.aspectj.util.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class CheckController {

    @RequestMapping("/orders/1")
    public String checkOrder() throws IOException {
        File file = new File("src/main/resources/check.txt");
        return FileUtil.readAsString(file);
    }
}
