package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Table
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
