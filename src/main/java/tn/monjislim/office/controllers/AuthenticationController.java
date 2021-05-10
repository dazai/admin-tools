package tn.monjislim.office.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.monjislim.office.dao.IUserDao;
import tn.monjislim.office.entities.User;
import tn.monjislim.office.exceptions.BadRequestException;
import tn.monjislim.office.models.AuthenticationRequest;
import tn.monjislim.office.models.AuthenticationResponse;
import tn.monjislim.office.models.RestResponse;
import tn.monjislim.office.services.CustomUserDetailsService;
import tn.monjislim.office.services.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.status(200).body(new AuthenticationResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody AuthenticationRequest authenticationRequest){
        if (iUserDao.existsByName(authenticationRequest.getUserName())){
            throw new BadRequestException("User name already in use");
        }

        User user = new User();
        user.setName(authenticationRequest.getUserName());
        user.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
        iUserDao.save(user);

        return ResponseEntity.status(201).body(new RestResponse(true, "User created successfully"));
    }

}
