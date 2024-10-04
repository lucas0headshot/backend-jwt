package com.lucas.jwt.services;

import com.lucas.jwt.enterprise.exceptions.NotFoundException;
import com.lucas.jwt.models.domain.Produto;
import com.lucas.jwt.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository repository;
    private final ModelMapper modelMapper;


    public Produto salvar(Produto entidade) {
        return repository.save(entidade);
    }


    public List<Produto> listAll() {
        return repository.findAll();
    }


    public Produto findByID(UUID id) {
        return repository.findById(id).orElseThrow();
    }


    public Produto atualizar(Produto atualizado) {
        var byID = repository.findById(atualizado.getId()).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
        modelMapper.map(atualizado, byID);
        return repository.save(byID);
    }
}
