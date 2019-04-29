package com.njit.stusystem.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.njit.stusystem.dto.UserDTO;
import com.njit.stusystem.model.Admin;
import org.springframework.stereotype.Service;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/22 15:44
 */
@Service
public class TokenService {
    public String getToken(UserDTO user) {
        String token="";
        token= JWT.create().withAudience(user.getId(),user.getTypes())
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
