package com.demo.user.registration.model.domain.request;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class UserRequestDetails {
    @NotNull(message = "userName should not be null")
    @NotEmpty(message = "userName should not be empty")
    private String userName;

    @NotNull(message = "password should not be null")
    @NotEmpty(message = "password should not be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_#$%.]).{8,20}$", message="Weak password. 1.Minimum 8 characters, 2. At least 1 number 3. At least 1 Capitalized letter 4. At least 1 special character from set (_ # $ % .)")
    private String password;

    @NotNull(message = "ipAddress should not be null")
    @NotEmpty(message = "ipAddress should not be empty")
    private String ipAddress;

}
