package com.example.BloggingPlatform.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data

@NoArgsConstructor
@Table
@Entity

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    @NotEmpty
    private String firstName;

    @Column(nullable = false)
    @NotEmpty
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String blogName;

    private String blogBio;

    @Column(nullable = false)
    @NotEmpty
    private String password;

    @Column(nullable = false)
    @Past
    @NotNull
    private LocalDate dob;

    @Column(unique = true , nullable = false)
    @Email
    @NotBlank
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number should be in the format XX-XXXXXXXXXX")
    private String phoneNumber;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean isBlueTicked;



    public Users(String firstName, String lastName, String blogName, String blogBio, String password, LocalDate dob, String email, String phoneNumber, boolean isBlueTicked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.blogName = blogName;
        this.blogBio = blogBio;
        this.password = password;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isBlueTicked = isBlueTicked;
    }
}
