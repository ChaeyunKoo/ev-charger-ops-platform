package com.example.backend.user.controller;

import com.example.backend.user.dto.LoginReq;
import com.example.backend.user.dto.SignupReq;
import com.example.backend.user.dto.UserRes;
import com.example.backend.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "사용자 API")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public ResponseEntity<UserRes> signup(@RequestBody SignupReq request) {
        UserRes response = userService.signup(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<UserRes> login(@RequestBody LoginReq request, HttpSession session) {
        UserRes response = userService.login(request);
        session.setAttribute("user", response);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "로그아웃")
    @GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}
