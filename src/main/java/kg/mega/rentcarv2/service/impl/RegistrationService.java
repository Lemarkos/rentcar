package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.model.Account;
import kg.mega.rentcarv2.repositories.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RegistrationService {
    private final AccountRepo accountRepo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Account register(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole("ROLE_USER");
        return accountRepo.save(account);
    }
}
