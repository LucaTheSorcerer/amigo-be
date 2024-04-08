package org.example.services;

import io.jsonwebtoken.JwtException;
import org.example.dtos.SignUpDto;
import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.example.utils.PasswordPolicyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.StringJoiner;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Autowired
    private PasswordPolicyValidator passwordPolicyValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByLogin(username);
        return user;
    }

    public UserDetails signUp(SignUpDto data) throws Exception {

        if (repository.findByLogin(data.login()) != null) {
            throw  new JwtException("Username already exists");
        }

        List<String> passwordErrors = passwordPolicyValidator.validatePassword(data.password());
        if (!passwordErrors.isEmpty()) {
            StringJoiner joiner = new StringJoiner(" ");
            passwordErrors.forEach(joiner::add);
            throw new Exception("Password does not meet the policy requirements: " + joiner);
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        return repository.save(newUser);

    }
}
