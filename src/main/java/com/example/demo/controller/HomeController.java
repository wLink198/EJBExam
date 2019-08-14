package com.example.demo.controller;

import com.example.demo.entity.Emi;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.Math;

@RestController
public class HomeController {
    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Emi emi) {
        double l = emi.getLoan();
        double r = emi.getRate();
        r = r / (12 * 100);
        double n = emi.getTenure();

        double result = l*r*Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
