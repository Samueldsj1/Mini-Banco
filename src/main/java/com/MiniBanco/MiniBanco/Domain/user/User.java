package com.MiniBanco.MiniBanco.Domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name= "users")
@Table(name = "users")
@Getter@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String document;
    private String password;
    private UserType userType;
    private BigDecimal balance;
    public User(){}

    public User(UserDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.document = dto.document();
        this.balance = dto.balance();
        this.password = dto.password();

    }
}
