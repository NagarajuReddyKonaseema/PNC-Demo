package com.demo.user.registration.controller;

import com.demo.user.registration.model.domain.request.UserRequestDetails;
import com.demo.user.registration.model.domain.response.UserResponseDetails;
import com.demo.user.registration.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/v1/")
public class UserRegistrationController {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @PostMapping(path="/createUser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDetails> createUser(
            @RequestBody @Valid UserRequestDetails userRequestDetails)
    {
        return ResponseEntity.ok(userAuthenticationService.getIpDetails(userRequestDetails));
    }
}

