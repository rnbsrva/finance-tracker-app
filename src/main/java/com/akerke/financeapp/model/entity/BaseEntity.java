package com.akerke.financeapp.model.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    @PrePersist
    public void toCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void toUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }
}
