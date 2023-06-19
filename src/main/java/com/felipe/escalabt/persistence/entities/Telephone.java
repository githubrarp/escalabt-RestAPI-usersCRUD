package com.felipe.escalabt.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="telephones")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10, nullable = false)
    private String number;
    @Column(length = 3,nullable = false)
    private String cityCode;
    @Column(length = 3, nullable = false)
    private String countryCode;

/*    @ManyToOne
    private User user;*/

}
