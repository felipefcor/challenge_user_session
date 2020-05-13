package com.kubikdata.domain.user;

import com.kubikdata.domain.valueObjects.Password;
import com.kubikdata.domain.valueObjects.PasswordNotValidException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PasswordShould {
    @Test
    public void throw_an_exception_when_the_password_is_too_long() {
        Assertions.assertThrows(PasswordNotValidException.class, () -> new Password("este password no es correcto ya que es muy largo"));
    }

    @Test
    public void throw_an_exception_when_the_password_is_too_short() {
        Assertions.assertThrows(PasswordNotValidException.class, () -> new Password("pass"));
    }

}
