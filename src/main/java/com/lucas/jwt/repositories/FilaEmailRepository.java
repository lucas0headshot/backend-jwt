package com.lucas.jwt.repositories;

import com.lucas.jwt.models.domain.FilaEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FilaEmailRepository extends JpaRepository<FilaEmail, UUID> {
    List<FilaEmail> findByEnviado(boolean enviado);
}
