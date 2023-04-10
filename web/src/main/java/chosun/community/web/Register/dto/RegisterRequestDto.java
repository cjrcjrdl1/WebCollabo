package chosun.community.web.Register.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequestDto {

    @NotNull
    private String insertId;
    @NotNull
    private String insertPass;

    @NotNull
    private String insertName;
}
