package com.sn.dtai.admin.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.sn.dtai.admin.domain.Applications} entity.
 */
public class ApplicationsDTO implements Serializable {

    private Long id;

    private String code;

    private String nom;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationsDTO)) {
            return false;
        }

        ApplicationsDTO applicationsDTO = (ApplicationsDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, applicationsDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationsDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", nom='" + getNom() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
