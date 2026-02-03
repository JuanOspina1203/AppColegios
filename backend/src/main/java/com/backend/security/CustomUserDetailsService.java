package com.backend.security;

import com.backend.model.entities.DirectorEntity;
import com.backend.repositories.IDirectorRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final IDirectorRepository directorRepository;

    public CustomUserDetailsService(IDirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DirectorEntity directorEntity = this.directorRepository.findByDirectorUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Director not found with username: " + username));
        return User.builder()
                .username(directorEntity.getDirectorUsername())
                .password(directorEntity.getDirectorPassword())
                .authorities(Collections.singletonList(
                        new SimpleGrantedAuthority("ROLE_" + directorEntity.getRole().name())
                ))
                .build();

    }
}