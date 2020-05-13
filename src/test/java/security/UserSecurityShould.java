package security;

import com.kubikdata.domain.entities.UserSecurity;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
import org.junit.Test;

import io.jsonwebtoken.Jwts;

public class UserSecurityShould {

    @Test
    public void create_correctly_a_user_token(){
        UserSecurity userSecurity = new UserSecurity();
        Username username = new Username("username");
        UserToken userToken = userSecurity.createJWTToken(username);
        String token = userToken.toString();

        String jwts = Jwts.parserBuilder().setSigningKey(userSecurity.getKey()).build().parseClaimsJws(token).getBody().getSubject();

        Assert.assertEquals("username", jwts);

    }

}
