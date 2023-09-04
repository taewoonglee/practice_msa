package com.example.owner.domain.request;

import com.example.owner.domain.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OwnerRequest {
    private String phoneNumber;
    private String email;
    public Owner toEntity(){
        return Owner.builder()
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
