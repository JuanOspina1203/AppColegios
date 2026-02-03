package com.backend.services.implementeds;

import com.backend.model.Mapper;
import com.backend.model.dtos.DirectorDto;
import com.backend.model.dtos.LoginDto;
import com.backend.model.dtos.LoginResponseDto;
import com.backend.model.dtos.TeacherDto;
import com.backend.model.entities.DirectorEntity;
import com.backend.repositories.IDirectorRepository;
import com.backend.repositories.ITeacherRepository;
import com.backend.security.JwtService;
import com.backend.services.IAuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImplemented implements IAuthService {

    private final IDirectorRepository directorRepository;
    private final Mapper mapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final ITeacherRepository teacherRepository;

    public AuthServiceImplemented(IDirectorRepository directorRepository,
                                  Mapper mapper,
                                  JwtService jwtService,
                                  AuthenticationManager authenticationManager,
                                  UserDetailsService userDetailsService,
                                  ITeacherRepository teacherRepository) {
        this.directorRepository = directorRepository;
        this.mapper = mapper;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public LoginResponseDto login(LoginDto loginDto) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        DirectorEntity directorEntity = this.directorRepository.findByDirectorUsername(loginDto.getUsername()).
                orElseThrow(() -> new RuntimeException("Director not found"));
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginDto.getUsername());
        String token = this.jwtService.generateToken(userDetails);
        return new LoginResponseDto(
                token,
                directorEntity.getDirectorUsername(),
                directorEntity.getRole().name()
        );
    }

    @Override
    public void saveDirector(DirectorDto directorDto) {
        this.directorRepository.save(this.mapper.convertDirectorDtoToDirectorEntity(directorDto));
    }

    @Override
    public DirectorDto findDirectorByUsername(String directorUsername) {
        return this.mapper.convertDirectorEntityToDirectorDto(this.directorRepository.findByDirectorUsername(directorUsername).orElseThrow(() -> new RuntimeException("Director not found")));
    }

    @Override
    public List<DirectorDto> findAll() {
        return this.directorRepository.findAll().
                stream().
                map(this.mapper::convertDirectorEntityToDirectorDto).
                toList();
    }

    @Override
    public List<TeacherDto> findAllTeachersInChargeByADirector(String directorUsername) {
        return this.teacherRepository.findAll()
                .stream()
                .filter(teacher -> {
                    if (teacher.getTeacherManagedByDirector() == null) return false;
                    return directorUsername.equals(teacher.getTeacherManagedByDirector().getDirectorUsername());
                })
                .map(this.mapper::convertTeacherEntityToTeacherDto)
                .toList();
    }
}