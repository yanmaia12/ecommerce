package com.yanmaia12.ecommerce.Service;

import com.yanmaia12.ecommerce.dto.CadastroDTO;
import com.yanmaia12.ecommerce.dto.UserResponseDTO;
import com.yanmaia12.ecommerce.enums.UserRole;
import com.yanmaia12.ecommerce.model.User;
import com.yanmaia12.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponseDTO userRegister(CadastroDTO cadastroDTO){
        if (userRepository.existsByEmail(cadastroDTO.email())) throw new BusinessException("Email já registrado!");
        if (!cadastroDTO.password().equals(cadastroDTO.confirmPassword())) throw new BusinessException("Senhas não coincidem!");

        User user = new User();
        user.setName(cadastroDTO.name());
        user.setEmail(cadastroDTO.email());
        user.setPassword(passwordEncoder.encode(cadastroDTO.password()));
        user.setRole(UserRole.USER);
        userRepository.save(user);

        return new UserResponseDTO(user.getName(), user.getId(), user.getEmail());
    }
}
