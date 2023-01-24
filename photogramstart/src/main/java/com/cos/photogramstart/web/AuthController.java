package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.User.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor // final 필드를 DI 할때 사용
@Controller // 1.IoC 2.파일을 리턴하는 컨트롤러
public class AuthController {

//    @Autowired
//    private AuthService authService;

    private final AuthService authService;
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    // 회원가입버튼 -> /auth/signup -> /auth/signin
    @PostMapping("/auth/signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { // key=value (x-www-form-urlencoded)

        // aop처리
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errorMap = new HashMap<>();
//
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
//                log.info(error.getDefaultMessage());
//                System.out.println("+++++++++++++++++++++++++++++++++++++++++");
//            }
//            throw new CustomValidationException("유효성 검사 실패", errorMap);
//        } else {

            log.info(signupDto.toString());
            // User <- SignupDto
            User user = signupDto.toEntity();
            log.info(user.toString());
            User userEntity = authService.회원가입(user);
            log.info(userEntity.toString());
            return "auth/signin";
//        }

    }
}
