package com.demo.user.registration.client.impl;

import com.demo.user.registration.client.IpAPIClient;
import com.demo.user.registration.model.client.IpAddressDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class IpAPIClientImpl implements IpAPIClient {

    @Autowired
    private WebClient.Builder webClient;

    @Override
    public IpAddressDetails validateCanadianUser(String ipAddress)
    {
        return webClient.build()
                .get()
                .uri("http://ip-api.com/json/"+ipAddress+"?fields=status,message,country,city")
                .retrieve()
                .bodyToMono(IpAddressDetails.class)
                .block();
    }

}
