package parvez.alam.observability.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parvez.alam.observability.service.AppService;

@RestController
@RequestMapping("/api")
public class AppController {

    @Resource
    private AppService appService;

    @GetMapping("noobserve/year")
    public ResponseEntity<String> getCurrentYearWithoutObservability() {
        return ResponseEntity.ok("No Observability " + appService.getCurrentYearWithoutObservability());
    }

    @GetMapping("observe/year")
    public ResponseEntity<String> getCurrentYearWithObservability() {
        return ResponseEntity.ok("With Observability " + appService.getCurrentYearWithObservability());
    }

}
