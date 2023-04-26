package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.model.Account;
import kg.mega.rentcarv2.repositories.AccountRepo;
import kg.mega.rentcarv2.security.AccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {
    private final AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepo.findByUsername(username);
        if (account.isEmpty())
            throw new UsernameNotFoundException("Account not found");
        return new AccountDetails(account.get());
    }
}
