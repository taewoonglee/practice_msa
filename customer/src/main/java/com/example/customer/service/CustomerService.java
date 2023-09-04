package com.example.customer.service;

import com.example.customer.repository.CustomerRepository;
import com.example.customer.request.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public void save(CustomerRequest customerRequest)
    {
        customerRepository.save(customerRequest.toEntity());
    }
}
