package com.ecom.jwt.api.controller;

import com.ecom.jwt.api.entity.AuthRequest;
import com.ecom.jwt.api.entity.Register;
import com.ecom.jwt.api.entity.UserResponse;
import com.ecom.jwt.api.repository.UserRepository;
import com.ecom.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to RiceMart !!";
    }

    @PostMapping("/authenticate")
    public UserResponse generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        UserResponse response = new UserResponse();
        try {
            response = userRepository.getLoginDetails(authRequest, response);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        response.setToken(jwtUtil.generateToken(authRequest.getUsername()));
        return response;
    }

    @PostMapping("/authenticate/test")
    public Register register(@RequestBody Register register){

        return register;

    }
}
