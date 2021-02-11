package ru.sapteh.model;
import lombok.*;

import javax.persistence.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_Name",nullable = false)
    private String firstname;

    @Column(name = "last_Name", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false)
    private String email;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRoles> userRoles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname ='" + lastName + '\'' +
                ", email = '" + email + '\'' +
                '}';
    }
}