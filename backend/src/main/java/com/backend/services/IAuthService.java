package com.backend.services;

import com.backend.model.dtos.DirectorDto;
import com.backend.model.dtos.LoginDto;
import com.backend.model.dtos.LoginResponseDto;
import com.backend.model.dtos.TeacherDto;

import java.util.List;

public interface IAuthService {
    LoginResponseDto login(LoginDto loginDto);
    void saveDirector(DirectorDto directorDto);
    DirectorDto findDirectorByUsername(String directorUsername);
    List<DirectorDto> findAll();
    List<TeacherDto> findAllTeachersInChargeByADirector(String directorUsername);
}