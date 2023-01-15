package com.cos.photogramstart.web.api;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.User.User;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMRespDto;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable Long id,
                               @Valid UserUpdateDto userUpdateDto,
                               BindingResult bindingResult, //꼭 @Valid가 적혀있는 다음 파라메터 적어야함
                               @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
                log.info(error.getDefaultMessage());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
            }
            throw new CustomValidationApiException("유효성 검사 실패", errorMap);
        } else {
            User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
            principalDetails.setUser(userEntity);
            return new CMRespDto<>(1, "회원수정완료", userEntity);
        }
    }
}