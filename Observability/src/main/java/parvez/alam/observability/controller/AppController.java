package parvez.alam.observability.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parvez.alam.observability.service.AppService;

@RestController
@RequestMapping("/api/current")
public class AppController {

    @Resource
    private AppService appService;

    @GetMapping("/year")
    public ResponseEntity<Integer> getCurrentYear() {
        return ResponseEntity.ok(appService.getCurrentYear());
    }
}
