package kg.mega.rentcarv2.controller;

import kg.mega.rentcarv2.dto.AccountDTO;
import kg.mega.rentcarv2.dto.AuthenticationDTO;
import kg.mega.rentcarv2.mapper.AccountMapper;
import kg.mega.rentcarv2.model.Account;
import kg.mega.rentcarv2.security.JWTUtil;
import kg.mega.rentcarv2.service.impl.RegistrationService;
import kg.mega.rentcarv2.util.AccountValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegistrationService registrationService;
    private final AccountValidator accountValidator;
    private final JWTUtil jwtUtil;
    private final AccountMapper accountMapper;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/registration")
    public Map<String, String> register(@RequestBody @Valid AccountDTO accountDTO,
                                        BindingResult bindingResult){
        Account account = accountMapper.toEntity(accountDTO);
        accountValidator.validate(account, bindingResult);

        if (bindingResult.hasErrors())
            return Map.of("message","Error");

        registrationService.register(account);

        String token = jwtUtil.generateToken(account.getUsername());
        return Map.of("jwt-token",token);
    }

    @PostMapping("/login")
    public Map<String, String> performLogin(@RequestBody AuthenticationDTO authenticationDTO){
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),
                        authenticationDTO.getPassword());

        try {
            authenticationManager.authenticate(authInputToken);
        }catch (BadCredentialsException e){
            return Map.of("message", "Incorrect credentials");
        }
        String token = jwtUtil.generateToken(authenticationDTO.getUsername());
        return Map.of("jwt-token", token);
    }
}
