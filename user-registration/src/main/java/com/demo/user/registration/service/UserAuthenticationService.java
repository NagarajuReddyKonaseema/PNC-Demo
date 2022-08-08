package com.demo.user.registration.service;

import com.demo.user.registration.client.IpAPIClient;
import com.demo.user.registration.exception.IpNotFoundException;
import com.demo.user.registration.mapper.IpAddressToUserDetailsMapper;
import com.demo.user.registration.model.client.IpAddressDetails;
import com.demo.user.registration.model.domain.request.UserRequestDetails;
import com.demo.user.registration.model.domain.response.UserResponseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserAuthenticationService {

    @Autowired
    private IpAPIClient ipAPIClientImpl;

    @Autowired
    private IpAddressToUserDetailsMapper ipAddressToUserDetailsMapper;


    public UserResponseDetails getIpDetails(UserRequestDetails userRequestDetails)
    {
        IpAddressDetails ipAddressDetails=ipAPIClientImpl.validateCanadianUser(userRequestDetails.getIpAddress());

        if(null == ipAddressDetails.getCountry())
            throw new IpNotFoundException("Invalid IP address");
        else if(!"Canada".equalsIgnoreCase(ipAddressDetails.getCountry()) )
            throw new IpNotFoundException("The provided ip address belongs to:"+ipAddressDetails.getCountry());




         return ipAddressToUserDetailsMapper.mapUserDetails(ipAddressDetails,userRequestDetails);
    }





}
