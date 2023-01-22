package com.cos.photogramstart.web.dto.user;

import com.cos.photogramstart.domain.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDto {
    private boolean pageOwnerState;
    private int imageCount;
    private User user;
}
