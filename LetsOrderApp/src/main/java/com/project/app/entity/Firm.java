package com.project.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = "Firm")
public class Firm extends User {

    @Column(name = "FIRM_NAME")
    @NotNull
    private String firmName;

    @Column(name = "FIRM_CODE")
    @NotNull
    private String firmCode;
}
