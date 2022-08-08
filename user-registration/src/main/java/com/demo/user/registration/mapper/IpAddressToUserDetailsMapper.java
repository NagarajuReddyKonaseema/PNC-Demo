package com.demo.user.registration.mapper;

import com.demo.user.registration.model.client.IpAddressDetails;
import com.demo.user.registration.model.domain.request.UserRequestDetails;
import com.demo.user.registration.model.domain.response.UserResponseDetails;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IpAddressToUserDetailsMapper {

    public UserResponseDetails mapUserDetails(IpAddressDetails ipAddressDetails, UserRequestDetails userRequestDetails)
    {
        UserResponseDetails newUserDetails= new UserResponseDetails();
        newUserDetails.setMessage("Congratulations!! "+userRequestDetails.getUserName()+"(account) from "+ipAddressDetails.getCity()+"(city) has been created successfully");
        newUserDetails.setConfirmationNumber(UUID.randomUUID().toString());
        return newUserDetails;

    }
}
