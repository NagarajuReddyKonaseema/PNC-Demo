package com.demo.user.registration.model.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpAddressDetails {

    private String query;
    private String status;
    private String country;
    private String city;

}
