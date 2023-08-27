package com.alex.jwt.backendtest.controller;



import com.alex.jwt.backendtest.dto.CredentialDto;
import com.alex.jwt.backendtest.dto.UserDto;
import com.alex.jwt.backendtest.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialDto credentialDto){
        System.out.println("HIiii");
       UserDto user = userService.login(credentialDto);
       System.out.println(credentialDto.login());
       return ResponseEntity.ok(user);
    }
}
