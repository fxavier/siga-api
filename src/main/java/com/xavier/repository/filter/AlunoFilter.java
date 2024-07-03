package com.xavier.repository.filter;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AlunoFilter {

    @QueryParam("primeiroNome")
    private String primeiroNome;
    @QueryParam("segundoNome")
    private String segundoNome;
    @QueryParam("apelido")
    private String apelido;
    @QueryParam("numero")
    private String numero;
    
}
