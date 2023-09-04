package com.example.customer.controller;

import com.example.customer.request.CustomerRequest;
import com.example.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public void save(@RequestBody CustomerRequest customerRequest)
    {
        customerService.save(customerRequest);
    }
}
