package com.example.customer.request;

import com.example.customer.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomerRequest {
    private String phoneNumber;
    private String email;
    public Customer toEntity(){
        return Customer.builder()
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }

}
