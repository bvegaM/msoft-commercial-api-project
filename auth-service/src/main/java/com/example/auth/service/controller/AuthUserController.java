package com.example.auth.service.controller;


import com.example.auth.service.dto.AuthUserDto;
import com.example.auth.service.dto.TokenDto;
import com.example.auth.service.security.JwtProvider;
import com.example.auth.service.service.AuthUserServiceImpl;
import com.example.auth.service.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthUserController {


    @Autowired
    private AuthUserServiceImpl authUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserDto userDTO){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(),userDTO.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
            String jwt = jwtUtil.createToken(userDetails);
            return ResponseEntity.ok().body(TokenDto.builder().jwt(jwt).build());
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(TokenDto.builder().jwt("Bad Credentials").build(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String token){
        try{
            TokenDto tokenDto = authUserService.validate(token);
            if(tokenDto == null){
                throw new Exception();
            }
            return ResponseEntity.ok().body(tokenDto);
        }catch (Exception e){
            return new ResponseEntity<>(TokenDto.builder().jwt("Token not valid!!").build(),HttpStatus.FORBIDDEN);
        }
    }

}
