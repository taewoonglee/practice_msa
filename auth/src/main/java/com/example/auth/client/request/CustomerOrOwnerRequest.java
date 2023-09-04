package com.example.auth.client.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerOrOwnerRequest {
    private UUID id;
    private String name;
    private String number;
}
