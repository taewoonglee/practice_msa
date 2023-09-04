package com.example.auth.client.api;

import com.example.auth.client.request.CustomerOrOwnerRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient("CEO-SERVICE")
public interface OwnerClient {
    @PostMapping("/api/v1/owner")
    ResponseEntity<Void> saveOwner(CustomerOrOwnerRequest customerOrOwnerRequest);

}
