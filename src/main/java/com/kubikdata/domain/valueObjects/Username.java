package com.kubikdata.domain.valueObjects;

import java.util.Objects;

public class Username {

    private String username;

    public Username(String username) {
        if(username.length() > 20 || !(username.chars().allMatch(Character::isLetterOrDigit))) throw new UsernameNotValidException();
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Username username1 = (Username) o;
        return Objects.equals(username, username1.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
