package com.project.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "US_USER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class User {
    @Id
    @SequenceGenerator(name = "us_user", sequenceName = "US_USER_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "us_user")
    private Long id;

    @Column(name = "PASSWORD")
    @NotNull //TODO not blank kullanılabilir mi denemeli
    @Size(max = 8, message = "Şifre 8 karakterli olmalı!")
    private String password;

    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;


    public enum UserType {
        CUSTOMER("Customer"), FIRM("Firm");
        public final String text;
        private UserType(String text) {
            this.text = text;
        }
    }
}
