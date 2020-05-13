package user;

import com.kubikdata.domain.UserCatalog;
import com.kubikdata.domain.entities.User;
import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;


public class UserCatalogShould {

    @Test
    public void add_and_get_users_to_catalog(){
        UserCatalog userCatalog = new UserCatalog();
        Username username = new Username("myUsername");
        UserId userId = new UserId(1);
        User userTest = new User(userId, username, new UserToken("usertoken"), LocalDate.now());

        userCatalog.add(userId, userTest);

        Assert.assertEquals(userTest, userCatalog.get(userId));
    }
}
