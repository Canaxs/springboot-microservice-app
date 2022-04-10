package com.microservice.apigateway.service;

import com.microservice.apigateway.converter.ApiUserConverter;
import com.microservice.apigateway.model.ApiUser;
import com.microservice.apigateway.model.UserAuthRes;
import com.microservice.userservice.dto.UserDto;
import com.microservice.userservice.model.User;
import com.microservice.userservice.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ApiUserConverter apiUserConverter;

    @Override
    public UserAuthRes authenticate(UserDto userDto) throws Exception {
        User inDB = userRepository.findByUsername(userDto.getUsername());
        if(inDB == null || !(inDB.getPassword().equals(userDto.getPassword()))) {
            throw new Exception();
        }
        String token = Jwts.builder().setSubject(""+inDB.getId()).signWith(SignatureAlgorithm.HS512, "microservice").compact();
        UserAuthRes userAuthRes = new UserAuthRes();
        userAuthRes.setUsername(inDB.getUsername());
        userAuthRes.setToken(token);
        return userAuthRes;
    }

    @Override
    public UserDetails getUserDetails(String token) {
        JwtParser parser = Jwts.parser().setSigningKey("microservice");
        try {
            parser.parse(token);
            Claims claims = parser.parseClaimsJws(token).getBody();
            long userId = new Long(claims.getSubject());
            User user = userRepository.getOne(userId);
            ApiUser apiUser = apiUserConverter.getUser(user);
            ApiUser actualUser = (ApiUser)((HibernateProxy)apiUser).getHibernateLazyInitializer().getImplementation();
            return actualUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
