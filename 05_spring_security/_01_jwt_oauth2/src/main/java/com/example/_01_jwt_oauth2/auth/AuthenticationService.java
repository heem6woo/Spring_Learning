package com.example._01_jwt_oauth2.auth;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.example._01_jwt_oauth2.config.JwtService;
import com.example._01_jwt_oauth2.token.Token;
import com.example._01_jwt_oauth2.token.TokenRepository;
import com.example._01_jwt_oauth2.user.Role;
import com.example._01_jwt_oauth2.user.User;
import com.example._01_jwt_oauth2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example._01_jwt_oauth2.token.TokenType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private void saveUserToken(User savedUser, String jwtToken) {
        var token = Token.builder()
                .user(savedUser)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> tokens = tokenRepository.findAllValidTokensByUser(user.getId());

        if(tokens.isEmpty()) return;
        tokens.forEach( t-> {
            t.setExpired(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(tokens);
    }


    public AuthenticationResponse register(RegisterRequest registerRequest) {
        // save it the database
        User user = User.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        // difference between builder and constructor
        saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) throws ChangeSetPersister.NotFoundException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var savedUser = repository.findByEmail(request.getEmail())
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        var jwtToken = jwtService.generateToken(savedUser);

        revokeAllUserTokens(savedUser);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

}
