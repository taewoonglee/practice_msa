package com.example.auth.client.api;

import com.example.auth.client.request.CustomerOrOwnerRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("CUSTOMER-SERVICE")
public interface CustomerClient {
    @PostMapping("/api/v1/customer")
    ResponseEntity<Void> saveCustomer(CustomerOrOwnerRequest customerOrOwnerRequest);

}