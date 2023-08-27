package com.alex.jwt.backendtest.services;


import com.alex.jwt.backendtest.dto.CredentialDto;
import com.alex.jwt.backendtest.dto.UserDto;
import com.alex.jwt.backendtest.entities.User;
import com.alex.jwt.backendtest.exceptions.AppException;
import com.alex.jwt.backendtest.mappers.UserMapper;
import com.alex.jwt.backendtest.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private  final UserMapper userMapper;

    public UserDto login(CredentialDto credentialDto){
      User user = userRepository.findByLogin(credentialDto.login())
                .orElseThrow(()-> new AppException("Unknown user", HttpStatus.NOT_FOUND));
      if(passwordEncoder.matches(CharBuffer.wrap(credentialDto.password()),
              user.getPassword())){
          return userMapper.toUserDto(user);
      }
      throw new AppException("Invalid password",HttpStatus.BAD_REQUEST);
    }
}
