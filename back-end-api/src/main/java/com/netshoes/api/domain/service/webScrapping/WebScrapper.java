package com.netshoes.api.domain.service.webScrapping;

import java.io.IOException;
import java.math.BigDecimal;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

import com.netshoes.api.domain.model.Produto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WebScrapper {
    
    private static final String NETSHOES_BASE_URL = "https://www.netshoes.com.br/";

    public Produto scrape(String ref) throws IOException{
        
        Connection conn = Jsoup.connect(NETSHOES_BASE_URL + ref);
        Response resp = conn.execute();
        Document doc = conn.get();

        if (resp.statusCode() != 200) {
            throw new HttpStatusException(resp.statusMessage() , resp.statusCode(), resp.url().toString());
        }
        
        String titulo = doc.select("[data-productname]").text();
        String precoString = doc.select("#hiddenPriceSaleInCents").attr("value");
        BigDecimal preco = stringToPrice(precoString);
        String urlImagem = doc.select(".photo-figure > .zoom").attr("src");
        String descricao = doc.select("#features > [itemprop=description]").text();

        return new Produto(titulo, preco, urlImagem, descricao);
    }

    private BigDecimal stringToPrice(String s){
        Double d = Double.parseDouble(s) / 100;
        return BigDecimal.valueOf(d);
    }
}
