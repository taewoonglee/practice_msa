package com.example.auth.service;

import com.example.auth.client.api.CustomerClient;
import com.example.auth.client.api.OwnerClient;
import com.example.auth.client.request.CustomerOrOwnerRequest;
import com.example.auth.config.JwtService;
import com.example.auth.domain.entity.Role;
import com.example.auth.domain.entity.User;
import com.example.auth.repository.UserRepository;
import com.example.auth.request.LoginRequest;
import com.example.auth.request.SignupRequest;
import com.example.auth.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final CustomerClient customerClient;
    private final OwnerClient ownerClient;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void signUp(SignupRequest signupRequest)
    {
        User build = User.builder()
                .name(signupRequest.getName())
                .number(signupRequest.getNumber())
                .role(Role.valueOf(signupRequest.getRole()))
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .build();
        User save = userRepository.save(build);
        CustomerOrOwnerRequest customerOrOwnerRequest =
                new CustomerOrOwnerRequest(save.getId(), save.getName(), save.getNumber());
        if(save.getRole()==Role.OWNER)
        {
            ResponseEntity<Void> response  = ownerClient.saveOwner(customerOrOwnerRequest);
            if(response.getStatusCode()!= HttpStatus.CREATED)
            {
                String msa=save.getRole().name()+"-SERVICE DEAD";
                throw new RuntimeException(save.getRole().name()+ "-Service dead");
            }
        }
        else {
            ResponseEntity<Void> response =customerClient.saveCustomer(customerOrOwnerRequest);
            if(response.getStatusCode()!= HttpStatus.CREATED)
            {
                String msa=save.getRole().name()+"-SERVICE DEAD";
                throw new RuntimeException(save.getRole().name()+ "-Service dead");
            }
        }
    }
    public LoginResponse login(LoginRequest loginRequest)
    {
        Optional<User> byEmail= userRepository.findByEmail(loginRequest.getEmail());
        User user = byEmail.orElseThrow(()->new IllegalArgumentException("USER NOT FOUND"));
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("USER NOT FOUND");
        }
        String token = jwtService.makeToken(user);
        return new LoginResponse(token, user.getRole().name());
    }
}
