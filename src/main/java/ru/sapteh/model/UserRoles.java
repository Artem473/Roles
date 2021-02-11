package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_roles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_registration", nullable = false)
    private String data_registration;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_roles")
    private Role role;

    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                ", data_registration=" + data_registration +
                ", userId=" + getUser().getId() +
                ", roleId=" + getRole().getId() +
                '}';
    }
}