package com.example.owner.service;

import com.example.owner.domain.request.OwnerRequest;
import com.example.owner.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {
    public final OwnerRepository ownerRepository;
    public void save(OwnerRequest ownerRequest)
    {
        ownerRepository.save(ownerRequest.toEntity());
    }
}
