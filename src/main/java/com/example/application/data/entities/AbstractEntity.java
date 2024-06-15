package com.example.application.data.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgenerator")
    @SequenceGenerator(name = "idgenerator", initialValue = 1000)
    private Long id;

    @Version
    private int version;

    @CreatedBy
    @Column(name = "created_by")
    private Long createdBy;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return self();
    }

    public int getVersion() {
        return version;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public T setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return self();
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public T setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return self();
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public T setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return self();
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public T setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
        return self();
    }

    @SuppressWarnings("unchecked")
    private T self() {
        return (T) this;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return getId().hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof AbstractEntity<?> that)) {
            return false; // null or not an AbstractEntity class
        }
        if (getId() != null) {
            return getId().equals(that.getId());
        }
        return super.equals(that);
    }
}
