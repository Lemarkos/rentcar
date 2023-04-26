package kg.mega.rentcarv2.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AccountDTO {
    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should consist of min 2 to 100 chars")
    private String username;
    private String password;
}