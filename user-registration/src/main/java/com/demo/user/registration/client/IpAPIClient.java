package com.demo.user.registration.client;

import com.demo.user.registration.model.client.IpAddressDetails;

public interface IpAPIClient {

    public IpAddressDetails validateCanadianUser(String ipAddress);

}
