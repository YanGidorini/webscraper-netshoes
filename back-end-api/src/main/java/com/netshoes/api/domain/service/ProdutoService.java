package com.netshoes.api.domain.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.netshoes.api.domain.model.Produto;
import com.netshoes.api.domain.service.webScraping.WebScraper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

    private WebScraper webScraper;

    public Produto buscar(String ref) throws IOException {
        return webScraper.scrape(ref);
    }
}
