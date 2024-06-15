package com.example.application.data.dtos.geral;

import com.example.application.data.entities.geral.Usuario;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class UsuarioDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -7393599683742075163L;

    private final Long id;
    private final String username;
    private final String name;
    private final byte[] profilePicture;

    public UsuarioDto(Long id, String username, String name, byte[] profilePicture) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.profilePicture = profilePicture;
    }

    public static UsuarioDto fromEntity( Usuario entity) {
        return new UsuarioDto(entity.getId(), entity.getUsername(), entity.getName(), entity.getProfilePicture());
    }

    public static Usuario toEntity(final UsuarioDto dto) {
        return new Usuario()
            .setId(dto.getId())
            .setUsername(dto.getUsername())
            .setName(dto.getName())
            .setProfilePicture(dto.getProfilePicture().clone());
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UsuarioDto) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.username, that.username) &&
               Objects.equals(this.name, that.name) &&
               Arrays.equals(this.profilePicture, that.profilePicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, Arrays.hashCode(profilePicture));
    }

    @Override
    public String toString() {
        return "UsuarioDto[" +
               "id=" + id + ", " +
               "username=" + username + ", " +
               "name=" + name + ", " +
               "profilePicture=" + Arrays.toString(profilePicture) + ']';
    }

}