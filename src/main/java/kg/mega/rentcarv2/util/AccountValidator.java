package kg.mega.rentcarv2.util;

import kg.mega.rentcarv2.model.Account;
import kg.mega.rentcarv2.service.impl.AccountDetailsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@RequiredArgsConstructor
@Component
public class AccountValidator implements Validator {
    private final AccountDetailsService accountDetailsService;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Account.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        Account account = (Account) target;

        try {
            accountDetailsService.loadUserByUsername(account.getUsername());
        }catch (UsernameNotFoundException e){
            return;
        }
        errors.rejectValue("username", "", "Account already exists");
    }
}
