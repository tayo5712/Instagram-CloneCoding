package com.cos.photogramstart.web;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String profile(@PathVariable Long id) {
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String update(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        // 1. 추천
        System.out.println("세션정보" + principalDetails.getUser());

        // 2. 비추천
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();
        System.out.println("직접 찾은 세션 정보" + mPrincipalDetails.getUser());
        return "user/update";
    }
}
