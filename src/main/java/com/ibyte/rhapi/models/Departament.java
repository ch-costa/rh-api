package com.ibyte.rhapi.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_departament")
public class Departament  implements Serializable {

    private static final long serialVersionUID = 7347560122217988991L;


    private long id;
    private String descDepartament;
    private Date createdAt;
    private Date updatedAt;

    public Departament() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ds_departament", nullable = false, unique = true)
    @NotBlank(message = "Descrição do Setor deve ser informada")
    @Length(min = 2, max = 30, message = "Descrição deve ter entre 2 e 30 caracteres")
    public String getDescDepartament() {
        return descDepartament;
    }

    public void setDescDepartament(String descDepartament) {
        this.descDepartament = descDepartament;
    }

    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at")
    @UpdateTimestamp
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "Departament{" +
                "id=" + id +
                ", descDepartament='" + descDepartament + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
