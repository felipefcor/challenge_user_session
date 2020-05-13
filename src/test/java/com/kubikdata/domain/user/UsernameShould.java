package com.kubikdata.domain.user;

import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.domain.valueObjects.UsernameNotValidException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class UsernameShould {
    @Test
    public void throw_an_exception_when_the_username_is_too_long() {
        Assertions.assertThrows(UsernameNotValidException.class, () -> new  Username("usuario muy largo y no valido"));
    }

    @Test
    public void throw_an_exception_when_the_username_has_not_allowed_characters() {
        Assertions.assertThrows(UsernameNotValidException.class, () -> new  Username("usuari&&"));
    }
}
