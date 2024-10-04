package com.lucas.jwt.models.domain;

import com.lucas.jwt.models.EntityID;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends EntityID {
    private String login;
    private String senha;
}
