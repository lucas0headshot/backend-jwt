package com.lucas.jwt.models.domain;

import com.lucas.jwt.models.EntityID;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilaEmail extends EntityID {
    private String email;
    private Boolean enviado;
}
