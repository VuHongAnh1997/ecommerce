package com.diepvusinhtu1.ecommerce.controller;

import com.diepvusinhtu1.ecommerce.entity.*;
import com.diepvusinhtu1.ecommerce.repository.*;
import com.diepvusinhtu1.ecommerce.security.jwt.*;
import com.diepvusinhtu1.ecommerce.security.model.*;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtTokenProvider tokenProvider;

    public UserController(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
            )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

}
