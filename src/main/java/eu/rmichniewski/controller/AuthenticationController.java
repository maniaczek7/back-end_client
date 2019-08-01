package de.ertantoker.tutorial.controller;

import de.ertantoker.tutorial.exception.EntityNotFoundException;
import de.ertantoker.tutorial.model.Account;
import de.ertantoker.tutorial.repository.AccountRepository;
import de.ertantoker.tutorial.request.AuthenticationRequest;
import de.ertantoker.tutorial.response.JWTTokenResponse;
import de.ertantoker.tutorial.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

@CrossOrigin(origins = {
        "http://localhost:4200",
        "http://3.95.187.34"})
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationService authenticationService, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.authenticationService = authenticationService;
        this.accountRepository = accountRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<JWTTokenResponse> createCustomer(@RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(authenticationService.generateJWTToken(request.getUsername(), request.getPassword()), HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/signup")
    public void createUser(@RequestBody Account account) {
        System.out.println("User created");
        Account newAccount = new Account();
        newAccount.setFirstname(account.getFirstname());
        newAccount.setLastname(account.getLastname());
        newAccount.setUsername(account.getUsername());
        newAccount.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(newAccount);
    }
}
