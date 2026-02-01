package com.backend.controllers;

import com.backend.model.dtos.DirectorDto;
import com.backend.model.dtos.LoginDto;
import com.backend.model.dtos.LoginResponseDto;
import com.backend.model.dtos.TeacherDto;
import com.backend.routes.Routes;
import com.backend.services.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.AUTH_ROUTE)
public class AuthController {

    private final IAuthService service;

    public AuthController(IAuthService service) {this.service = service;}

    @PostMapping(Routes.AUTH_LOGIN)
    public ResponseEntity<LoginResponseDto> login(@Validated @RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(this.service.login(loginDto));
    }

    @PostMapping(Routes.AUTH_REGISTER)
    public ResponseEntity<String> register(@Validated @RequestBody DirectorDto directorDto) {
        this.service.saveDirector(directorDto);
        return ResponseEntity.ok("Director saved");
    }

    @GetMapping(Routes.AUTH_FIND_DIRECTOR)
    public ResponseEntity<DirectorDto> findDirector(@PathVariable String directorUsername) {
        return ResponseEntity.ok(this.service.findDirectorByUsername(directorUsername));
    }

    @GetMapping
    public ResponseEntity<List<DirectorDto>> findAllDirectors() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping(Routes.AUTH_TEACHERS_IN_CHARGE_OF_A_DIRECTOR + Routes.AUTH_FIND_DIRECTOR)
    public ResponseEntity<List<TeacherDto>> findAllTeachersInChargeOfADirector(@PathVariable String directorUsername) {
        return ResponseEntity.ok(this.service.findAllTeachersInChargeByADirector(directorUsername));
    }
}