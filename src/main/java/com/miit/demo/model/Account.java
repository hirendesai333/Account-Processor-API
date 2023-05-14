package com.miit.demo.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 1)
    private Long id;

    @Valid
    @NotEmpty(message = "FirstName is required")
    @Size(min = 3, message = "FirstName must have at least 3 characters")
    private String firstName;

    @Valid
    @NotEmpty(message = "LastName is required")
    @Size(min = 3, message = "LastName must have at least 3 characters")
    private String lastName;

    @Valid
    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email format")
    private String emailAddress;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
    @Column(length = 64)
    private String password;

    @Embedded
    @Valid
    private Address address;
}
