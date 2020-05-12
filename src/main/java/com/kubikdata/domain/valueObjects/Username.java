package com.kubikdata.domain.valueObjects;

public class Username {

    private String username;

    public Username(String username) {
        if(username.length() > 20 || !(username.chars().allMatch(Character::isLetterOrDigit))) throw new UsernameNotValidException();
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
