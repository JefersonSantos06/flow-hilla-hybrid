package com.example.application.data.entities.geral;

import com.example.application.data.entities.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity<Usuario> {

    private String username;
    private String name;

    @JsonIgnore
    private String hashedPassword;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Lob
    @Column(length = 1000000)
    private byte[] profilePicture;

    public String getUsername() {
        return username;
    }

    public Usuario setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public Usuario setName(String name) {
        this.name = name;
        return this;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public Usuario setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Usuario setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public Usuario setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public boolean hasRole(final Role role) {
        return this.roles.contains(role);
    }

    public boolean isAdmin() {
        return hasRole(Role.ADMIN);
    }
}
