package com.mahadi.poin_of_sale.dto;

import jakarta.validation.constraints.NotBlank;

public record ResetPasswordRequest(@NotBlank(message = "Email is required") String email,
                                   @NotBlank(message = "Verification code is required") String verificationCode,
                                   @NotBlank(message = "Password is required") String password) {

}
