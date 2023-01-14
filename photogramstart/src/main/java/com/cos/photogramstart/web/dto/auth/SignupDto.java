package com.cos.photogramstart.web.dto.auth;

import com.cos.photogramstart.domain.User.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SignupDto {
    private String username;
    private String password;
    private String email;
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
