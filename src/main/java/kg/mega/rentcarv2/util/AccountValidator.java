package kg.mega.rentcarv2.util;

import kg.mega.rentcarv2.model.Account;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@RequiredArgsConstructor
@Component
public class AccountValidator implements Validator{
    private final UserDetailsService userDetailsService;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Account.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        Account account = (Account) target;

        try {
            userDetailsService.loadUserByUsername(account.getUsername());
        }catch (UsernameNotFoundException e){
            return;
        }
        errors.rejectValue("username", "", "Account already exists");
    }
}
