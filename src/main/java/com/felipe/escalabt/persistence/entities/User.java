package com.felipe.escalabt.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "usersTable")
public class User {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 20, nullable = false, unique = true)
    private String email;
    @Column(length = 20, nullable = false)
    private String password;
    private boolean isActive;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
//    @JsonIgnore
    private LocalDateTime createdAt;
    @UpdateTimestamp
//    @JsonIgnore
    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="user_id")
    private Set<Telephone> telephones = new HashSet<>();

}
