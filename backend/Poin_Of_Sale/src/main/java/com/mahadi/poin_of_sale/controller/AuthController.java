package com.mahadi.poin_of_sale.controller;

import com.mahadi.poin_of_sale.dto.AuthRequest;
import com.mahadi.poin_of_sale.dto.AuthResponse;
import com.mahadi.poin_of_sale.dto.ClientResponse;
import com.mahadi.poin_of_sale.dto.ResetPasswordRequest;
import com.mahadi.poin_of_sale.service.AuthService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }

    @GetMapping("/forgot-password")
    public ResponseEntity<ClientResponse> forgotPassword(@NotNull @RequestParam String email) {
        return ResponseEntity.ok(authService.forgotPassword(email));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ClientResponse> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        return ResponseEntity.ok(authService.resetPassword(request));
    }


}
