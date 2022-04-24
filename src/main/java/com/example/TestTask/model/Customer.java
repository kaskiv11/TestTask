package com.example.TestTask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "costumer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_name", length = 50)
        @Size(min=2, max = 50, message = "At least 2 characters")
        private String fullName;


        @Column(name = "email" , unique = true, length = 100)
        @Size(min=2, max = 100, message = "At least 2 characters")
        @Email
        @Pattern(regexp = "\\w+@\\w+\\.\\w+(,\\s*\\w+@\\w+\\.\\w+)*")
        private String email;

        @Null(message = "mobileNumber is required")
        @Column(name = "phone",length = 14)
        @Size(min=6, max = 14, message = "At least 2 characters")
        private String phone;

    private Boolean isActive;

}
