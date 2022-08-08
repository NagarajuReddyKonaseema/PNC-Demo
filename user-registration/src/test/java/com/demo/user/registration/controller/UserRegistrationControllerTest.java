package com.demo.user.registration.controller;

import com.demo.user.registration.model.domain.request.UserRequestDetails;
import com.demo.user.registration.model.domain.response.UserResponseDetails;
import com.demo.user.registration.service.UserAuthenticationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserRegistrationController.class)
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAuthenticationService userAuthenticationService;

    private String userRequestDetailsJson="{\"userName\":\"raj\",\"password\":\"423232325aA.\",\"ipAddress\":\"24.48.0.1\"}";

    @Test
    public void createUser() throws Exception
    {
        UserResponseDetails mockUserResponseDetails=new UserResponseDetails("Raj123 account created successfully","12121323345");

        // userAuthenticationService.getIpDetails to respond back with mockUserResponseDetails
        Mockito.when(userAuthenticationService.getIpDetails(
                Mockito.any(UserRequestDetails.class))).thenReturn(mockUserResponseDetails);

        // Send userRequestDetailsJson as body to /v1/createUser
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/createUser")
                .accept(MediaType.APPLICATION_JSON).content(userRequestDetailsJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


}
