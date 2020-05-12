package com.kubikdata.domain.entities;

import com.kubikdata.domain.valueObjects.Username;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class UserSecurity {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String createJWTToken(Username username) {
         String token = Jwts
                .builder()
                .setSubject(username.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(key)
                .compact();

        return token;
    }

    public Key getKey(){
        return key;
    }

}
