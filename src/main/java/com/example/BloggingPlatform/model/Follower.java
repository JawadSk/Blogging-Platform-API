package com.example.BloggingPlatform.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followerTableId;

    @OneToOne
    private User user;

    @OneToOne
    private User follower;

    public Follower(Object o, User myUser, User otherUser) {
    }
}
