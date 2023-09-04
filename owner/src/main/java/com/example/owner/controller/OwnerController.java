package com.example.owner.controller;


import com.example.owner.domain.request.OwnerRequest;
import com.example.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/owner")

public class OwnerController {
    private final OwnerService ownerService;
    @PostMapping
    public void save(@RequestBody OwnerRequest ownerRequest)
    {
        ownerService.save(ownerRequest);
    }
}
