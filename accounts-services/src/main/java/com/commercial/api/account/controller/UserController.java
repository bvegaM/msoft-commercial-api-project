package com.commercial.api.account.controller;

import com.commercial.api.account.config.security.JWTUtil;
import com.commercial.api.account.dto.UserDTO;
import com.commercial.api.account.service.UserDetailsServiceImpl;
import com.commercial.api.account.service.UserServiceImpl;
import com.commercial.api.account.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private Environment environment;

    @PostMapping("/authenticate")
    public ResponseEntity<Object> login(@RequestBody UserDTO userDTO){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(),userDTO.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            return ResponseHandler.generateOperation("JWT Generated!!!", HttpStatus.OK,jwt);
        }catch (BadCredentialsException e){
            return ResponseHandler.generateOperation("JWT Not Generated!!!", HttpStatus.BAD_REQUEST, e.getCause());
        }
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<UserDTO> userDTOS = userService.findAll();
            return ResponseHandler.generateOperation(environment.getProperty("response.successfully.get"), HttpStatus.OK,userDTOS);
        }catch (Exception ex){
            return ResponseHandler.generateOperation(environment.getProperty("response.successfully.get.error"), HttpStatus.BAD_REQUEST,ex.getCause());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        try{
            UserDTO userDTO = userService.findById(id);
            if (userDTO == null)
                throw new Exception(environment.getProperty("response.successfully.get.error"));
            return ResponseHandler.generateOperation(environment.getProperty("response.successfully.get"), HttpStatus.OK,userDTO);
        }catch (Exception ex){
            return ResponseHandler.generateOperation(environment.getProperty("response.successfully.get.error"), HttpStatus.BAD_REQUEST,ex.getCause());
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Object> findByUsername(@PathVariable("username") String username){
        try{
            UserDTO userDTO = userService.findByUsername(username);
            if (userDTO == null)
                throw new Exception(environment.getProperty("response.successfully.get.error"));
            return ResponseHandler.generateOperation(environment.getProperty("response.successfully.get"), HttpStatus.OK,userDTO);
        }catch (Exception ex){
            return ResponseHandler.generateOperation(environment.getProperty("response.successfully.get.error"), HttpStatus.BAD_REQUEST,ex.getCause());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserDTO userDTO){
        try{
            UserDTO userDTOSave = userService.save(userDTO);
            if (userDTOSave == null)
                throw new Exception(environment.getProperty("response.successfully.post.error"));
            return ResponseHandler.generateOperation(environment.getProperty("response.successfully.post"), HttpStatus.OK,userDTOSave);
        }catch (Exception ex){
            return ResponseHandler.generateOperation(environment.getProperty("response.successfully.post.error"), HttpStatus.BAD_REQUEST,ex.getCause());
        }
    }

}
