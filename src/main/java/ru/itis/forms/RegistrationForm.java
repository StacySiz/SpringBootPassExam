package ru.itis.forms;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationForm {
    String firstName;
    String lastName;
    String email;
    String password;
}
