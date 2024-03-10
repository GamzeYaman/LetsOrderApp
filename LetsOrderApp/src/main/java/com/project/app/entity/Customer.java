package com.project.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "Customer")
public class Customer extends User {

    @Column(name = "USERNAME", nullable = false)
    @Size(max = 100)
    private String username;

    @Column(name = "CUSTOMER_NAME")
    @NotNull
    private String customerName;

    @Column(name = "CUSTOMER_SURNAME")
    @NotNull
    private String customerSurname;
}
