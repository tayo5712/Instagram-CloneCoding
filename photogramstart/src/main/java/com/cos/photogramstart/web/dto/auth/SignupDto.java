package com.cos.photogramstart.web.dto.auth;

import com.cos.photogramstart.domain.User.User;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SignupDto {
    @NotBlank
    @Size(max = 20, message = "유저네임은 20글자 이하여야 합니다.")
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
