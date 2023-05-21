package com.netshoes.api.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    
    private String titulo;
    private BigDecimal preco;
    private String urlImagem;
    private String descricao;
}
