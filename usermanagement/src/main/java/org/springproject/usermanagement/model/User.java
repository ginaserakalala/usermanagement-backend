package org.springproject.usermanagement.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "`user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name= "user_seq", sequenceName = "user_seq",allocationSize=1)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;

    public User(String username, String email, String password, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
