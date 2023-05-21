package com.netshoes.api.domain.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.netshoes.api.domain.model.Produto;
import com.netshoes.api.domain.service.webScrapping.WebScrapper;

@Service
public class ProdutoService {
    
    private Produto produto;

    public Produto buscar(String ref) throws IOException {
        WebScrapper scrapper = new WebScrapper();
        produto = scrapper.scrape(ref);

        return produto;
    }
}
