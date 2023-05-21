package com.netshoes.api.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netshoes.api.domain.model.Produto;
import com.netshoes.api.domain.service.ProdutoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ProdutoController {

    private ProdutoService service;
    
    @GetMapping("{ref}")
    public ResponseEntity<Produto> buscar(@PathVariable String ref) throws IOException {
        Produto produto = service.buscar(ref);
        
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }

        return ResponseEntity.notFound().build();
    }
}
