package domain;

import java.time.LocalDate;

public class UserSession {
    private final UserID userID;
    private final Username username;
    private final UserToken token;
    private final LocalDate date;

    public UserSession(UserID userID, Username username, UserToken token, LocalDate date) {
        this.userID = userID;
        this.username = username;
        this.token = token;
        this.date = date;
    }
}
