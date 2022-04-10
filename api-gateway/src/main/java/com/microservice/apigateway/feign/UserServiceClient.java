package com.microservice.apigateway.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public class UserServiceClient {
}
