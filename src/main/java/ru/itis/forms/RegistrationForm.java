package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegistrationForm {
    String firstName;
    String lastName;
    String email;
    String password;
}
