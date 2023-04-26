package kg.mega.rentcarv2.mapper;

import kg.mega.rentcarv2.dto.AccountDTO;
import kg.mega.rentcarv2.model.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    Account toEntity (AccountDTO accountDTO);
}
