package com.yanmaia12.ecommerce.service;

import com.yanmaia12.ecommerce.config.JwtService;
import com.yanmaia12.ecommerce.dto.LoginDTO;
import com.yanmaia12.ecommerce.dto.LoginResponseDTO;
import com.yanmaia12.ecommerce.dto.RegisterDTO;
import com.yanmaia12.ecommerce.dto.UserResponseDTO;
import com.yanmaia12.ecommerce.enums.UserRole;
import com.yanmaia12.ecommerce.exception.BusinessException;
import com.yanmaia12.ecommerce.model.User;
import com.yanmaia12.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Transactional
    public UserResponseDTO userRegister(RegisterDTO registerDTO){
        if (userRepository.existsByEmail(registerDTO.email())) throw new BusinessException("Email já registrado!");
        if (!registerDTO.password().equals(registerDTO.confirmPassword())) throw new BusinessException("Senhas não coincidem!");

        User user = new User();
        user.setName(registerDTO.name());
        user.setEmail(registerDTO.email());
        user.setPassword(passwordEncoder.encode(registerDTO.password()));
        user.setRole(UserRole.USER);
        userRepository.save(user);

        return new UserResponseDTO(user.getName(), user.getId(), user.getEmail());
    }

    @Transactional
    public LoginResponseDTO userLogin(LoginDTO loginDTO){
        if (!userRepository.existsByEmail(loginDTO.email())) throw new BusinessException("Email não registrado!");

        var authToken = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());

        var auth = authenticationManager.authenticate(authToken);

        var user = (User) auth.getPrincipal();
        String token = jwtService.gerarToken(user);

        return new LoginResponseDTO(token);
    }
}

