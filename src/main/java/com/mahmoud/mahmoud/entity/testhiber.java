package com.mahmoud.mahmoud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "suiii")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class testhiber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userID;
    @Column(name = "username")
    private String username;
}
