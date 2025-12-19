package com.example.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class SecuredController {
    @GetMapping("hello")
    public ResponseEntity<String> securedGet(){
        return ResponseEntity.ok("Hello Spring Security!");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> securedAdminGet(){
        return ResponseEntity.ok("Hello User!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> securedUserGet(){
        return ResponseEntity.ok("Hello Admin!");
    }
}
