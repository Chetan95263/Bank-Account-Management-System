package com.app.Bank_Account_Management_System.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Role role = Role.USER;

    @OneToOne
    private AccountHolder accountHolder;
}
