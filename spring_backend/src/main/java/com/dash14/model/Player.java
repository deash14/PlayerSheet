package com.dash14.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "first_name")
    @NotEmpty(message = "* Please Enter First  Name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "* Please Enter Last Name")
    private String lastName;
} 