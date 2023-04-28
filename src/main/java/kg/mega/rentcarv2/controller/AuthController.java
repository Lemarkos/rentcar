package kg.mega.rentcarv2.controller;

import kg.mega.rentcarv2.dto.AuthenticationRequest;
import kg.mega.rentcarv2.dto.AuthenticationResponse;
import kg.mega.rentcarv2.dto.RegisterRequest;
import kg.mega.rentcarv2.security.AuthenticationService;
import kg.mega.rentcarv2.util.AccountValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    private final AccountValidator accountValidator;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
