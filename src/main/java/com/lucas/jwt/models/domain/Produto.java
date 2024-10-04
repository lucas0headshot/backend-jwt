package com.lucas.jwt.models.domain;

import com.lucas.jwt.models.EntityID;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto extends EntityID {
    private String nome;
    private String descricao;
    private Double preco;
}
